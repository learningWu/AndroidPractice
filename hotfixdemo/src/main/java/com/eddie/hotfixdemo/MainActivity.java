package com.eddie.hotfixdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.Executors;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button showTitle, fix, killSelf;
    TextView tvTitle;

    public File apk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTitle = findViewById(R.id.show_title);
        fix = findViewById(R.id.fix);
        killSelf = findViewById(R.id.kill_self);
        tvTitle = findViewById(R.id.title);


        showTitle.setOnClickListener(this);
        fix.setOnClickListener(this);
        killSelf.setOnClickListener(this);

        apk = new File( Environment.getExternalStorageDirectory(),"debug.apk");

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // 复制 assets 中apk
                AssetManager assets = MainActivity.this.getAssets();
                try (
                        InputStream inputStream = assets.open("debug.apk");
                        BufferedSink bufferOut = Okio.buffer(Okio.sink(apk))) {
                    bufferOut.writeAll(Okio.source(inputStream));
                    bufferOut.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_title:
                Title title = new Title();
                tvTitle.setText(title.title);
                break;
            case R.id.fix:
                // getClassLoader . pathList
                // getClassLoader . pathList . dexElement
                try {
                    ClassLoader classLoader = getClassLoader();
                    Class loaderClazz = BaseDexClassLoader.class;
                    Field pathListField = loaderClazz.getDeclaredField("pathList");
                    pathListField.setAccessible(true);
                    Object pathList = pathListField.get(classLoader);
                    Class<?> pathListClazz = pathList.getClass();
                    Field dexElementField = pathListClazz.getDeclaredField("dexElements");
                    dexElementField.setAccessible(true);
                    Object dexElement = dexElementField.get(pathList);

                    // 替换
                    PathClassLoader pathClassLoader = new PathClassLoader(apk.getPath(), BaseDexClassLoader.getSystemClassLoader());
                    Object newPathList = pathListField.get(pathClassLoader);
                    Object newDexElement = dexElementField.get(newPathList);
                    dexElementField.set(pathList, newDexElement);
                    Toast.makeText(this, "修复成功", LENGTH_SHORT).show();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                // 修复
                break;
            case R.id.kill_self:
                // 杀死进程
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
        }
    }
}
