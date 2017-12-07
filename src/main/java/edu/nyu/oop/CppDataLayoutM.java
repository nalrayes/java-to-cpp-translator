package edu.nyu.oop;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;
import java.util.Map;
import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.Node;

public class CppDataLayoutM {


    public static ArrayList<cppImplementationClass> methods;

    public CppDataLayoutM(){

        methods = new  ArrayList<cppImplementationClass>();

    }

    //MAIN METHOD IMPLEMENTATION
    public static class cppImplementationMainMethodClass {
        //Class to handle the main method
        String mainMethodName;
        String mainMethodReturnType;
        //Property to hold the block class for the method
        TranslatedBlock transLatedBlockForImpMainMethod;

        public cppImplementationMainMethodClass (CustomMethodClass m){
            this.mainMethodName = "int main(void)";
            this.mainMethodReturnType = "return 0";
            //Instant the main methods block
            this.transLatedBlockForImpMainMethod = new TranslatedBlock(m.getMethodsBlock());
            System.out.println("$hb22 " + transLatedBlockForImpMainMethod.getFieldDeclarations().size());
            System.out.println("MAIN METHOD CLASS NAME");
            System.out.println("MAIN METHOD");

            System.out.println("MAIN METHOD NAME");
            System.out.println(this.mainMethodName);

            System.out.println("MAIN METHOD RETURN TYPE");
            System.out.println(this.mainMethodReturnType);
        }
    }

    //METHODS IMPLEMENTATIONS
    public static class cppImplementationClass{
        String className;
        String vTableInit;
        String classMethodInit;
        String vTableDecl;
        String parentClass;

        ArrayList<cppMethodImplementation> cppMethodImplementations;

        public ArrayList<cppMethodImplementation> getCppMethodImplementations() {
            return cppMethodImplementations;
        }

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
                cppMethodImplementation methodImp = new cppMethodImplementation(method, this.className, theClass);
                this.cppMethodImplementations.add(methodImp);
            }

        }

        // A a = new A();
    }







    // TODO: Check for arrays which has dimensions.
    // If newArrayExpression it has , check concrete dimensions
    public static class CustomFieldDeclaration{

        int position;
        boolean isArray;
        boolean isClass;
        String fieldDeclarationLine;

        ArrayList<String> mainFileLines;

        public CustomFieldDeclaration(Node fieldDec, int position){

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
            //String fieldDeclarationLine ="";
            String qualifiedIdentifier ="";

            System.out.println("$fd " + fieldDec);
            if (fieldDec.getNode(0).size() > 0 ){

                for (int modifierIndex = 0; modifierIndex < fieldDec.getNode(0).size(); modifierIndex++){
                    String getModifier = fieldDec.getNode(0).getString(modifierIndex);

                    //modifiers.add(getModifier);
                    fieldDeclarationLine += getModifier + " ";
                }


            } // end check modifiers

            // 1: Type(QualifiedIdentifier("string value"),
            if (fieldDec.getNode(1).size() > 0 ) {

                System.out.println("Get Type");
                System.out.println((fieldDec.getNode(1)));
                // for (int j = 0; j < fieldDec.getNode(1).size(); j++){

                // if value of node is null continue
                //if (fieldDec.getNode(1).getNode(0) == null){continue;}
                // sub 0th node is Qualified Identifier
                if (!fieldDec.getNode(1).getNode(0).isEmpty()){
                    System.out.println("$t2\n " + fieldDec.getNode(1));

                    System.out.println("QI\n" + fieldDec.getNode(1).getNode(0));
                    System.out.println("QIVal\n" + fieldDec.getNode(1).getNode(0).getString(0));

//                                if (fieldDec.getNode(1).getNode(j).getString(0) == null){continue;}
                    // fieldDec.getNode(1) is varName, which may be as so: var or var[]
                    qualifiedIdentifier = fieldDec.getNode(1).getNode(0).getString(0);
                    System.out.println("$qq \n"+ qualifiedIdentifier );
                    fieldDeclarationLine += qualifiedIdentifier;
                }

                // if not null the variable is declaring an array
                if (fieldDec.getNode(1).getNode(1) != null){
                    isArray = true;
                    System.out.println("$drone1\n" + fieldDec.getNode(1).getNode(1));

                    Node declaratorVarNode = fieldDec.getNode(1).getNode(1);
                    System.out.println("$decvar\n " + declaratorVarNode);

                    for (int i = 0; i < declaratorVarNode.size(); i++){
                        fieldDeclarationLine += "[]";
                    }
                    //fieldDeclarationLine += "[]";
                    //fieldDeclarationLine = __rt::Ptr<double, __rt::array_policy> q = new double[5];


                }
                if (!fieldDec.getNode(1).isEmpty()){
                    fieldDeclarationLine += " ";
                }









                System.out.println("types vals " + fieldDec.getNode(1).getNode(0));


                // }



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
                    if (declarator.getNode(2) != null) {


                        if (declarator.getNode(2).getName().equals("NewClassExpression")) {
                            isClass = true;
                            Node newClassExpression = declarator.getNode(2);
                            declaratorValue += newClassExpression.getNode(2).getString(0);

                            // check if the instantiated object has arguments
                            System.out.println("$n1 " + newClassExpression);
                            if (!newClassExpression.getNode(3).isEmpty()) {

                                Node arguments = newClassExpression.getNode(3);

                                declaratorValue += "(";
                                for (int x = 0; x < arguments.size(); x++) {

                                    if (arguments.getNode(x).getName().equals("PrimaryIdentifier")) {
                                        declaratorValue += "__" + arguments.getNode(x).getString(0);

                                    } else {
                                        declaratorValue += arguments.getNode(x).getString(0);
                                    }

                                    if (x < arguments.size() - 1) {
                                        declaratorValue += ",";

                                    }

                                }
                                declaratorValue += ")";


                            } else {
                                declaratorValue += "()";
                            }
                            // end of check if instantiated object has arguments


                        }
                        // end of if NewClassExpression
                        // examples of this are in test 24 - ~31
                        else if (declarator.getNode(2).getName().equals("NewArrayExpression")) {
                            System.out.println("$NewArray");
                            System.out.println("$FOUNDARRAY1");
                            System.out.println(declarator.getNode(2));
                            //declaratorValue = "new ";
                            Node newArrayExpression = declarator.getNode(2);
                            // declaratorValue += newArrayExpression.getNode(0);

                            String qualifiedId = newArrayExpression.getNode(0).getString(0);

                            Node arrayDimensions = newArrayExpression.getNode(1);


                            System.out.println("$express111 \n" + newArrayExpression);
                            Node arrayDimValue = arrayDimensions.getNode(0);
                            System.out.println("$Arr1 \n" + arrayDimensions + " \n" + arrayDimValue);
                            declaratorValue += "__" + qualifiedId;
                            for (int i = 0; i < arrayDimensions.size(); i++) {

                                declaratorValue += "[" + arrayDimensions.getNode(i).getString(0) + "]";
                            }


                            // declaratorValue += qualifiedId + "[" + arrayDimValue + "]";


                        } else if (declarator.getNode(2).getName().equals("SubscriptExpression")) {
                            Node subscriptExpression = declarator.getNode(2);
                            System.out.println("$sub1 " + subscriptExpression);

                            if (!subscriptExpression.getNode(0).getName().equals("SubscriptExpression")) {
                                System.out.println("$sub2 " + subscriptExpression);

                                //System.out.println("$idk2 " + subscriptExpression.getNode(0).getNode(0));
                                System.out.println("$sub3 " + subscriptExpression);

                                declaratorValue += "[" + subscriptExpression.getNode(1).getString(0) + "]";


                            } else {
                                subscriptExpression = declarator.getNode(2).getNode(0);
                                //System.out.println("$sub1 " + subscriptExpression);

                                System.out.println("$vvv " + subscriptExpression);
                                System.out.println("$v1 " + declaratorValue);
                                declaratorValue += "[" + subscriptExpression.getNode(0).getString(0) + "]";
                                declaratorValue += "[" + subscriptExpression.getNode(1).getString(0) + "]";


                            }


                        }
                        //else if(){}


                        else {
                            System.out.println("$err \n " + declarator.getNode(2));
                            declaratorValue = declarator.getNode(2).getString(0);
                            System.out.println("$dim111 \n" + declaratorValue);

                            //System.out.println("wowee " + declaratorValue);
                        }
                        String fullDeclarator = declaratorVar + " = " + declaratorValue;
                        fieldDeclarationLine += fullDeclarator;

                    }
                    else{
                        fieldDeclarationLine += declaratorVar;

                    }




                    //declarators.add(fieldDeclarationLine);

                    if (isArray){

                        //__rt::Ptr<double, __rt::array_policy> q = new double[5];
                        fieldDeclarationLine = "__rt::Ptr<"+qualifiedIdentifier +", __rt::array_policy> " + declaratorVar + " = new " +declaratorValue;


                    }

                    if (isClass){

                        //__rt::Ptr<int, __rt::object_policy> p = new int(5);
                        fieldDeclarationLine = "__rt::Ptr<" +qualifiedIdentifier + ", __rt::object_policy> "+ declaratorVar + " = new ";

                    }

                    mainFileLines.add(fieldDeclarationLine);

                    System.out.println("$FULL FIELD $D33 \n " +  fieldDeclarationLine);


                } // end of if declarator isn't empty













            } // end of get Declarators

            // TODO: Translate expression statements





        } // end of CustomFieldDeclaration Constructor


    }


    public static class CustomTestObject{

        String thing;
      public CustomTestObject(){
        thing = "thingy";


        }

    }

    public static class TranslatedBlock{
        // blocks have field declarations
        // Expression statements
        int test;
        ArrayList<CustomFieldDeclaration> fieldDeclarations;
        ArrayList<CustomTestObject> customTestObjects;

        ArrayList<String> testList;

//            public ArrayList<CustomFieldDeclaration> getFieldDeclarations() {
//                return fieldDeclarations;
//            }

        public TranslatedBlock(Node b){
            this.test = 1;
            this.fieldDeclarations = new ArrayList<CustomFieldDeclaration>();

            testList = new ArrayList<String>();

            System.out.println(b.size());

            for (int i = 0; i < b.size(); i++){

                // either a field declaration or ExpressionStatement

                // if field declaration
                // its subnodes have the following indices:
                // 0: modifiers
                // 1: Type(QualifiedIdentifier("string value"),
                // 2: Declarators(0:Declarator("dec variable"), 1:someVal/null, 2:NewClassExpression,
                // 3: Arguments("some string/null"), someVal/null)
System.out.println("$bii " + b.getNode(i));
                if (b.getNode(i).getName().equals("FieldDeclaration")){
                    CustomFieldDeclaration fd = new CustomFieldDeclaration(b.getNode(i), i);
                    System.out.println("$here1");
                    this.fieldDeclarations.add(fd);
                    System.out.println("$line4111 " +  this.getFieldDeclarations().size());
                }
                // else if ExpressionStatement
                // its subnodes have the following indices
                // 0:
                else{
                    System.out.println("Expression Statement\n " + b.getNode(i));
                }



            }
            System.out.println("WALLE123 length " + this.fieldDeclarations.size());


        }

        public ArrayList<CustomFieldDeclaration> getFieldDeclarations() {
            return this.fieldDeclarations;
        }
    }

    //TODO NICHOLAS
    //Constructor helper stuff
    // private static class typeTranslatorToDeafultTypeClass(String type){



    //  }



    //TODO NICHOLAS
    public static class cppMethodImplementation{
        String returnType;
        String name;
        String params;

        Node theBlock;
        TranslatedBlock translatedBlock;

        // TODO: add property to hold translated block, check if the block has a constructor
        boolean isConstuctor = false;
        //Constructor properties -> this will be null unless its a constructor. Use isConstructor to check if this is is constructor when adding to the ASTMTree
        String deafultConstructorLayout;

        public cppMethodImplementation(CustomMethodClass methodClass, String className, CustomClassObject theMethodsClass){
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

            //If this is a constructor handle for constructor default properties
            //TODO NIC
            if (this.isConstuctor == true){
                //Handle constructor
                this.deafultConstructorLayout = "__" + theMethodsClass.getClassName() + "::__" + theMethodsClass.getClassName() + "() : __vptr(&__vtable), ";
                //Get the class Var's
                ArrayList<CustomVariablesClass> arrayOfClassFields = theMethodsClass.getClassVariables();
                for (CustomVariablesClass varInClass : arrayOfClassFields){
                    String varName = varInClass.getName();
                    String deafultType;

                }
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

            //Translate the block for the method
            this.translatedBlock = new TranslatedBlock(this.theBlock);
            System.out.println("$im here222 " + this.translatedBlock.getFieldDeclarations().size());





            // for (translatedBlock.);


//System.out.println("$fdSize " + this.translatedBlock.getFieldDeclarations().size());
            System.out.println("$test " + translatedBlock.test);


            //System.out.println("$g " + this.translatedBlock.fieldDeclarations.get(0));
            for (CustomFieldDeclaration fd : this.translatedBlock.getFieldDeclarations()){
                //System.out.println(fd.);
                //for (String l : translatedBlock.getFieldDeclarations())
                System.out.println("$line222 " + fd.fieldDeclarationLine);

            }


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
}

