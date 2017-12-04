package edu.nyu.oop;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;
import java.util.Map;
import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.Node;

public class CppDataLayoutM {

    public static ArrayList<CppDataLayoutM.cppImplementationClass> implementationClasses;

    public CppDataLayoutM(){
        //Use this default constructor to create the deafult __Object data layout
        implementationClasses = new ArrayList<cppImplementationClass>();
    }

    public static class cppImplementationClass{
     String className;
     String vTableInit;
     String classMethodInit;
     String vTableDecl;
     String parentClass;

     ArrayList<cppMethodImplementation> cppMethodImplementations;

     public cppImplementationClass (CustomClassObject theClass){
      if (theClass.getParentClass() == "None") {
          this.parentClass = "Object";
      } else {
          this.parentClass = theClass.getParentClass();
      }
      this.className = theClass.getClassName();
      this.vTableInit = "__" + this.className + "::__" + this.className +  "() : __vptr(&__vtable) {}";
      this.classMethodInit = "Class __" + this.className + "::__class() {\n" +
              "      static Class k =\n" +
              "        new __Class(__rt::literal(\"inputs.javalang." + this.className + "\"), __" + parentClass + "::__class());\n" +
              "      return k;\n" +
              "    }";
      this.vTableDecl = "__" + this.className + "_VT " + "__" + this.className + "::__vtable";
      this.cppMethodImplementations = new ArrayList<cppMethodImplementation>();

         System.out.println("CLASS NAME");
         System.out.println(this.className);
         System.out.println("CLASS VTABLE INIT");
         System.out.println(this.vTableInit);
         System.out.println("CLASS METHOD INIT");
         System.out.println(this.classMethodInit);
         System.out.println("CLASS VTABLE DECL");
         System.out.println(this.vTableDecl);


      for (CustomMethodClass method : theClass.getMethods()){
          cppMethodImplementation methodImp = new cppMethodImplementation(method, this.className);
          this.cppMethodImplementations.add(methodImp);
      }

     }

     //TODO
     private static class cppMethodImplementation{
         String returnType;
         String name;
         String params;

         Node theBlock;

         public cppMethodImplementation(CustomMethodClass methodClass, String className){
             CppDataLayout.typeTranslate typeTranslate = new CppDataLayout.typeTranslate();
             this.returnType = typeTranslate.translateType(methodClass.getReturnType());
             // name = __className
             this.name = "__" + className + "::" + methodClass.getName();
             // TODO: what if its static?
             this.params = "(" + className + " __this";
             for (CustomVariablesClass var : methodClass.getParameters()) {
                 this.params += ", " + var.type + " " + var.name;
             }
             this.params += ")";
             this.theBlock = methodClass.getMethodsBlock();

             System.out.println("METHOD NAME");
             System.out.println(this.name);

             System.out.println("METHOD PARAMS");
             System.out.println(this.params);

             System.out.println("METHOD RETURN");
             System.out.println(this.returnType);

             System.out.println("THE BLOCK");
             System.out.println(this.theBlock);




         }

     }






    }
}
