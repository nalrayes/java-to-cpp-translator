package edu.nyu.oop;

import java.util.ArrayList;

import edu.nyu.oop.*;
import xtc.tree.GNode;
import java.util.Map;
import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.Node;

public class CppDataLayoutM {



    public CppDataLayoutM(){

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
            this.transLatedBlockForImpMainMethod = new TranslatedBlock(m.getMethodsBlock(), false, null);

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
        String deafultConstructorImplementation;

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

            //Get the constructor implementations via the class fields
            this.deafultConstructorImplementation = "__" + theClass.getClassName() + "::__" + theClass.getClassName() + "() : __vptr(&__vtable)";
            //Add the class fields
            for (CustomVariablesClass varClass : theClass.getClassVariables()){
                typeTranslatorToDeafultTypeClass deafultTypeClassTranslator = new typeTranslatorToDeafultTypeClass();
                String deafultInstanceType = deafultTypeClassTranslator.translateDefaultType(varClass.getType());
                System.out.println(varClass.getType());
                this.deafultConstructorImplementation += ", " + varClass.getName() + "(" + deafultInstanceType + ")" + "\n" + "{}";
                System.out.println("THE DEAFULTE CONSTRUCTOR TYPE");
                System.out.println(this.deafultConstructorImplementation);
            }


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
    }

    // TODO: Check for arrays which has dimensions.
    // If newArrayExpression it has , check concrete dimensions
    public static class CustomFieldDeclaration{


        int position;
        boolean isArray;
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
            String fieldDeclarationLine ="";
            String qualifiedIdentifier ="";


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

                System.out.println("types vals " + fieldDec.getNode(1).getNode(0));

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
                    if(declarator.getNode(2) != null) {

                        // if declator instantiates an object
                        // must get the rhs
                        if (declarator.getNode(2).getName().equals("NewClassExpression")){
                            if (!isArray) {
                                declaratorValue = "new ";
                            }
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


                        } // end of if NewClassExpression
                        // examples of this are in test 24 - ~31
                        else if(declarator.getNode(2).getName().equals("NewArrayExpression")){
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
                            declaratorValue += "__" +qualifiedId;
                            for (int i = 0; i < arrayDimensions.size(); i++){

                                declaratorValue += "[" + arrayDimensions.getNode(i).getString(0) + "]";
                            }


                           // declaratorValue += qualifiedId + "[" + arrayDimValue + "]";

                        }
                        else if(declarator.getNode(2).getName().equals("SubscriptExpression")){
                            Node subscriptExpression = declarator.getNode(2);
                            System.out.println("$sub1 " + subscriptExpression);

                            if (!subscriptExpression.getNode(0).getName().equals("SubscriptExpression")){
                                System.out.println("$sub2 " + subscriptExpression);

                               //System.out.println("$idk2 " + subscriptExpression.getNode(0).getNode(0));
                                System.out.println("$sub3 " + subscriptExpression);

                                declaratorValue += "[" + subscriptExpression.getNode(1).getString(0) +"]";


                            }
                            else{
                                subscriptExpression = declarator.getNode(2).getNode(0);
                                //System.out.println("$sub1 " + subscriptExpression);

                                   System.out.println("$vvv " + subscriptExpression);
                                    System.out.println("$v1 " + declaratorValue);
                                    declaratorValue += "[" + subscriptExpression.getNode(0).getString(0) +"]";
                                    declaratorValue += "[" + subscriptExpression.getNode(1).getString(0) +"]";





                            }




                        }
                        else{
                            System.out.println("$err \n " + declarator.getNode(2));
                            declaratorValue = declarator.getNode(2).getString(0);
                            System.out.println("$dim111 \n" + declaratorValue);

                            //System.out.println("wowee " + declaratorValue);
                        }
                    }


                    String fullDeclarator = declaratorVar + " = " + declaratorValue;
                    fieldDeclarationLine += fullDeclarator;

                    //declarators.add(fieldDeclarationLine);

                    if (isArray){

                        //__rt::Ptr<double, __rt::array_policy> q = new double[5];
                        fieldDeclarationLine = "__rt::Ptr<"+qualifiedIdentifier +", __rt::array_policy> " + declaratorVar + " = new " +declaratorValue;


                    }

                    mainFileLines.add(fieldDeclarationLine);
                    System.out.println("$FULL FIELD $D222 \n " +  fieldDeclarationLine);


                } // end of if declarator isn't empty




                    //declarators.add(fieldDeclarationLine);
                    mainFileLines.add(fieldDeclarationLine);
                    System.out.println("FULL FIELD $D111 \n " +  fieldDeclarationLine);


                } // end of if declarator isn't empty













            } // end of get Declarators

            // TODO: Translate expression statements

        } // end of CustomFieldDeclaration Constructor
    }

    public static class TranslatedBlock{
        // blocks have field declarations
        // Expression statements
        ArrayList<CustomFieldDeclaration> fieldDeclarations;


        //Constructor properties
        boolean isConstructor;
        String deafultConsturctorCall;
        ArrayList<String> classLevelInitFields;

        public TranslatedBlock(Node b, boolean flag, CustomClassObject theMethodsClass){

            //If this is a constuctor handle the deafult/explcit constructor call
            //e.g. _Object::__init((Object) __this); OR __A::__init((A) __this, x1);
            this.isConstructor = flag;
            this.classLevelInitFields = new ArrayList<String> ();
            this.deafultConsturctorCall = "__Object::__init((Object) __this)";

            //Fields for standared method block
            fieldDeclarations = new ArrayList<CustomFieldDeclaration>();
            //System.out.println(b.size());

            for (int i = 0; i < b.size(); i++){

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
            }//End of for loop for block


        //TODO NICHOLAS
        //Constructor helper stuff
       // private static class typeTranslatorToDeafultTypeClass(String type){



      //  }










            //Handle Constructor Stuff
            if(this.isConstructor){
                //First check what type of default constructor is called by going through the block
                String superOrThis = "";
                for (int k = 0; k < b.size(); k++){
                    //Find if there is super etc..
                    if(b.getNode(k).getName().equals("ExpressionStatement")){
                        if(b.getNode(k).getNode(0).getName().equals("CallExpression")){
                            //Get the call expression node
                            Node callExpression = b.getNode(k).getNode(0);
                            if(callExpression.getString(2).equals("super")){
                                //Super is called
                                String arguments = "";
                                Node argumentNode = callExpression.getNode(3);
                                for (int g = 0; g < argumentNode.size(); g++){
                                    //Go through the arguments
                                    arguments += ", " + argumentNode.getNode(g).getString(0);
                                }
                                deafultConsturctorCall = "__" + theMethodsClass.getParentClass() + "::__init((" + theMethodsClass.getParentClass() + ") __this" + arguments + ")";
                            }
                            else if (callExpression.getNode(2).getName().equals("this")){
                                //This Call
                                deafultConsturctorCall =  "__init(__this)";
                            }
                        }
                    }
                }
                System.out.println("THE CONSTRUCTOR CALL IN CONSTRUCTOR BLOCK");
                System.out.println(deafultConsturctorCall);

                //Handle Class level field InIts
                //Get the class level fields
                //TEST 006
                //TEST 021
                ArrayList<CustomVariablesClass> classFields = theMethodsClass.getClassVariables();
                for (CustomVariablesClass classField : classFields){
                    



                    this.classLevelInitFields.add("ASD");
                }

            }//End of if constructor statement

        }//END OF Translate Block Constructor
    }

    //Constructor helper stuff
    private static class typeTranslatorToDeafultTypeClass{
        public String translateDefaultType(String javaType) {
            String DefaultType = "";
            switch (javaType) {
                case "int":
                    DefaultType = "0";
                    break;

                case "byte":
                    DefaultType = "0";
                    break;

                case "char":
                    DefaultType = "\u0000";
                    break;

                case "double":
                    DefaultType = "0.0d";
                    break;

                case "float":
                    DefaultType = "0.0f";
                    break;

                case "long":
                    DefaultType = "0L";
                    break;

                case "short":
                    DefaultType = "0";
                    break;

                case "boolean":
                    DefaultType = "false";
                    break;

                case "string":
                    DefaultType = "null";
                    break;

                default:
                    DefaultType = "null";
                    break;
            }
            return DefaultType;
        }
    }

    //TODO NICHOLAS
    public static class cppMethodImplementation{
        String returnType;
        String name;
        String params;

        //Block stuff
        Node theBlock;
        TranslatedBlock translatedBlock;

        //See if the method is a constructor
        boolean isConstuctor = false;

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
            translatedBlock = new TranslatedBlock(this.theBlock, this.isConstuctor, theMethodsClass);

            System.out.println("FIELD DECLARATIONS COUNT");
            System.out.println(this.translatedBlock.fieldDeclarations.size());


        }
    }

}

