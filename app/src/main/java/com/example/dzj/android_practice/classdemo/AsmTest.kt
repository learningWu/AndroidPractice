//package com.example.dzj.android_practice.classdemo
//
//import org.objectweb.asm.*
//
//class AsmTest {
//    class AddFieldAdapter(
//            private var fieldName: String, fieldAccess: Int, cv: ClassVisitor) : ClassVisitor(Opcodes.ASM4, cv) {
//        private var fieldType: String? = null
//        private var access = org.objectweb.asm.Opcodes.ACC_PUBLIC
//        private var isFieldPresent: Boolean = false
//
//        init {
//            this.cv = cv
//            this.access = fieldAccess
//        }
//
//        override fun visitField(
//                access: Int, name: String, desc: String, signature: String, value: Any): FieldVisitor {
//            if (name == fieldName) {
//                isFieldPresent = true
//            }
//            return cv.visitField(access, name, desc, signature, value)
//        }
//
//        override fun visitEnd() {
//            if (!isFieldPresent) {
//                val fv = cv.visitField(
//                        access, fieldName, fieldType, null, null)
//                fv?.visitEnd()
//            }
//            cv.visitEnd()
//        }
//
//        inner class CustomClassWriter {
//            lateinit var addFieldAdapter: AddFieldAdapter
//            val className = "java.lang.Integer"
//            val cloneableInterface = "java/lang/Cloneable"
//            var reader: ClassReader
//            var writer: ClassWriter
//
//            init {
//                reader = ClassReader(className)
//                writer = ClassWriter(reader, 0)
//            }
//
//            fun addField(): ByteArray {
//                addFieldAdapter = AddFieldAdapter(
//                        "aNewBooleanField",
//                        org.objectweb.asm.Opcodes.ACC_PUBLIC,
//                        writer)
//                reader.accept(addFieldAdapter, 0)
//                return writer.toByteArray()
//            }
//        }
//    }
//}