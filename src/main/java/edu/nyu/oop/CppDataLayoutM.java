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

        public static class CustomFieldDeclaration{

            int position;
            ArrayList<String> modifiers;
            String Type;
            ArrayList<String> declarators;
            ArrayList<String> arguments;
            ArrayList<String> mainFileLines;

            public CustomFieldDeclaration(Node fieldDec, int position){
                modifiers =new ArrayList<String>();
                declarators = new ArrayList<String>();
                arguments =new ArrayList<String>();
                mainFileLines =new ArrayList<String>();

                this.position = position;

                // for (int i = 0; i < fieldDec.size(); i++){

                // get all indices of field declaration and translate
                // 0: modifiers
                // 1: Type(QualifiedIdentifier("string value"),
                // 2: Declarators(0:Declarator("dec variable"), 1:someVal/null, 2:NewClassExpression,
                // 3: Arguments("some string/null"), someVal/null)

                // 0: modifiers
               // System.out.println("fdeez " + fieldDec);
                String fieldDeclarationLine ="";

                if (fieldDec.getNode(0).size() > 0 ){

                    for (int modifierIndex = 0; modifierIndex < fieldDec.getNode(0).size(); modifierIndex++){
                        String getModifier = fieldDec.getNode(0).getString(modifierIndex);

                        modifiers.add(getModifier);
                        fieldDeclarationLine += getModifier + " ";
                    }


                } // end check modifiers

                // 1: Type(QualifiedIdentifier("string value"),
                if (fieldDec.getNode(1).size() > 0 ) {

                    System.out.println("Get Type");
                    System.out.println((fieldDec.getNode(1)));
                    String qualifiedIdentifier;
                    for (int j = 0; j < fieldDec.getNode(1).size(); j++){

                        // if value of node is null continue
                        if (fieldDec.getNode(1).getNode(j) == null){continue;}
                        // sub 0th node is Qualified Identifier
                        if (fieldDec.getNode(1).getNode(j).getName().equals("QualifiedIdentifier")){

                            System.out.println("QI\n" + fieldDec.getNode(1).getNode(j));
                            System.out.println("QIVal\n" + fieldDec.getNode(1).getNode(j).getString(0));

//                                if (fieldDec.getNode(1).getNode(j).getString(0) == null){continue;}
                            qualifiedIdentifier = fieldDec.getNode(1).getNode(j).getString(0);
                            fieldDeclarationLine += qualifiedIdentifier + " ";
                        }






                        System.out.println("types vals " + fieldDec.getNode(1).getNode(j));


                    }



                } // end of sub 0 check field dec's modifiers

                // check field dec's declarators
                String declaratorValue = "";


                Node declarators = fieldDec.getNode(2);
                System.out.println("deez " + declarators);

                if (declarators.size() > 0 ) {
                    System.out.println("DECLARATORS1 ");

                    System.out.println(declarators);
                    Node declarator = declarators.getNode(0);
                    System.out.println("mydec1" + declarator);

                    if (!declarator.isEmpty()){


                        String declaratorVar = declarator.getString(0);

                        // if declator instantiates an object
                        // must get the rhs
                        if (declarator.getNode(2).getName().equals("NewClassExpression")){
                            declaratorValue = "new ";
                            Node newClassExpression = declarator.getNode(2);
                            declaratorValue += newClassExpression.getNode(2).getString(0);

                            // check if the instantiated object has arguments
                            if (!newClassExpression.getNode(3).isEmpty()){

                                Node arguments = newClassExpression.getNode(3);

                                declaratorValue+="(";
                                for (int x = 0; x < arguments.size(); x++) {
                                    declaratorValue += arguments.getNode(x).getString(0);

                                    if (x < arguments.size()-1){
                                        declaratorValue += ",";

                                    }

                                }
                                declaratorValue+=")";


                            }else{
                                declaratorValue += "()";
                            }
                            // end of check if instantiated object has arguments


                        } // end of if NewClassExpression
                        else{
                            declaratorValue = declarator.getNode(2).getString(0);
                            //System.out.println("wowee " + declaratorValue);
                        }

                        String fullDeclarator = declaratorVar + " = " + declaratorValue;
                        fieldDeclarationLine += fullDeclarator;

                        //declarators.add(fieldDeclarationLine);
                        mainFileLines.add(fieldDeclarationLine);
                        System.out.println("FULL FIELD DEC \n " +  fieldDeclarationLine);


                    } // end of if declator isn't empty













                } // end of get Declarators





            } // end of CustomFieldDeclaration Constructor


        }

        public static class TranslatedBlock{
            // blocks have field declarations
            // Expression statements
            ArrayList<CustomFieldDeclaration> fieldDeclarations;


            public TranslatedBlock(Node b){

                fieldDeclarations = new ArrayList<CustomFieldDeclaration>();
                System.out.println(  b.size());

                for (int i =0; i < b.size(); i++){

                    // either a field declaration or ExpressionStatement

                    // if field declaration
                    // its subnodes have the following indices:
                    // 0: modifiers
                    // 1: Type(QualifiedIdentifier("string value"),
                    // 2: Declarators(0:Declarator("dec variable"), 1:someVal/null, 2:NewClassExpression,
                    // 3: Arguments("some string/null"), someVal/null)

                    if (b.getNode(i).getName().equals("FieldDeclaration")){
                        CustomFieldDeclaration fd = new CustomFieldDeclaration(b.getNode(i), i);
                        this.fieldDeclarations.add(fd);

                    }
                    // else if ExpressionStatement
                    // its subnodes have the following indices
                    // 0:
                    else{
                        System.out.println("Expression Statement\n " + b.getNode(i));
                    }






                }

            }

        }

        //TODO
        private static class cppMethodImplementation{
            String returnType;
            String name;
            String params;

            Node theBlock;

            // TODO: add property to hold translated block, check if the block has a constructor

            boolean isConstuctor = false;


            //blockimpclass [= ]

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

                //Check if this
                if(this.name.contains("init")){
                    this.isConstuctor = true;
                }

                System.out.println("METHOD NAME");
                System.out.println(this.name);

                System.out.println("METHOD PARAMS");
                System.out.println(this.params);

                System.out.println("METHOD RETURN");
                System.out.println(this.returnType);

                System.out.println("THE BLOCK");
                System.out.println(this.theBlock);
                System.out.println("block12345");

                TranslatedBlock translatedBlock = new TranslatedBlock(theBlock);






//                 System.out.println("start i");
//                 System.out.print();
//
//                for (int j = 0; j < this.theBlock.getNode(i).size(); j++){
//
//                    System.out.println("in j block " + this.theBlock.getNode(i).getNode(j) +"\n");
//
//
//
//                 }
//                 System.out.println("inc i");
//
//
//
//             }

                // System.out.println()

                // TODO: translate the block


            }

        }
        // A a = new A();




    }
}

