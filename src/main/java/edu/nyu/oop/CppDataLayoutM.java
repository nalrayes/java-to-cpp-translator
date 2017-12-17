package edu.nyu.oop;

import java.util.ArrayList;

import edu.nyu.oop.*;
import jdk.nashorn.internal.ir.ExpressionStatement;
import xtc.tree.GNode;
import java.util.Map;
import edu.nyu.oop.util.CppDataLayout;
import xtc.tree.Node;

public class CppDataLayoutM {


    public CppDataLayoutM() { }

    //MAIN METHOD IMPLEMENTATION
    public static class cppImplementationMainMethodClass {
        //Class to handle the main method
        String mainMethodName;
        String mainMethodReturnType;
        //Property to hold the block class for the method
        TranslatedBlock transLatedBlockForImpMainMethod;

        public cppImplementationMainMethodClass(CustomMethodClass m) {
            this.mainMethodName = "int main(void)";
            this.mainMethodReturnType = "return 0";
            //Instant the main methods block

            this.transLatedBlockForImpMainMethod = new TranslatedBlock(m.getMethodsBlock(), false, null);
            this.transLatedBlockForImpMainMethod.returnStatement = "return 0";
            System.out.println("MAIN METHOD CLASS NAME");
            System.out.println("MAIN METHOD");

            System.out.println("MAIN METHOD NAME");
            System.out.println(this.mainMethodName);

            System.out.println("MAIN METHOD RETURN TYPE");
            System.out.println(this.mainMethodReturnType);
        }
    }

    //METHODS IMPLEMENTATIONS
    public static class cppImplementationClass {
        String className;
        String vTableInit;
        String classMethodInit;
        String vTableDecl;
        String parentClass;
        String deafultConstructorImplementation;

        ArrayList<cppMethodImplementation> cppMethodImplementations;

        public ArrayList<cppMethodImplementation> getCppMethodImplementations() {
            return cppMethodImplementations;
        }

        //Default init for class
        //If the class override this with its own implementation this will be null
        cppMethodImplementation defaultInIt;

        public cppImplementationClass(CustomClassObject theClass) {
            if (theClass.getParentClass() == "None") {
                this.parentClass = "Object";
            } else {
                this.parentClass = theClass.getParentClass();
            }
            this.className = theClass.getClassName();
            this.vTableInit = "__" + this.className + "::__" + this.className + "() : __vptr(&__vtable) \n             {}";
            this.classMethodInit = "Class __" + this.className + "::__class() {\n" +
                    "      static Class k =\n" +
                    "        new __Class(__rt::literal(\"inputs.javalang." + this.className + "\"), __" + parentClass + "::__class());\n" +
                    "      return k;\n" +
                    "    }";
            this.vTableDecl = "__" + this.className + "_VT " + "__" + this.className + "::__vtable;";
            this.cppMethodImplementations = new ArrayList<cppMethodImplementation>();

            //Get the constructor implementations via the class fields
            this.deafultConstructorImplementation = "__" + theClass.getClassName() + "::__" + theClass.getClassName() + "() : __vptr(&__vtable)";
            //Add the class fields
            for (CustomVariablesClass varClass : theClass.getClassVariables()) {
                typeTranslatorToDeafultTypeClass deafultTypeClassTranslator = new typeTranslatorToDeafultTypeClass();
                String deafultInstanceType = deafultTypeClassTranslator.translateDefaultType(varClass.getType());
                //System.out.println(varClass.getType());
                this.deafultConstructorImplementation += ", " + varClass.getName() + "(" + deafultInstanceType + ")";
            }
            this.deafultConstructorImplementation += "\n" + "    {}";
            System.out.println("THE DEAFULTE CONSTRUCTOR TYPE");
            System.out.println(this.deafultConstructorImplementation);

            System.out.println("CLASS NAME");
            System.out.println(this.className);
            System.out.println("CLASS VTABLE INIT");
            System.out.println(this.vTableInit);
            System.out.println("CLASS METHOD INIT");
            System.out.println(this.classMethodInit);
            System.out.println("CLASS VTABLE DECL");
            System.out.println(this.vTableDecl);

            //Create def init method for each class
            this.defaultInIt = new cppMethodImplementation();
            this.defaultInIt.name = theClass.className + " " + "__" + theClass.className + "::__init(" + theClass.className + " __this)";
            this.defaultInIt.returnType = "__this";
            this.defaultInIt.isConstuctor = true;
            TranslatedBlock blockForDef = new TranslatedBlock();
            blockForDef.classLevelInitFields = new ArrayList<String>();
            blockForDef.deafultConsturctorCall = "__Object::__init((Object) __this)";
            if(theClass.getParentClass() != "None"){
                blockForDef.deafultConsturctorCall = "__" + theClass.getParentClass() + "::__init((" + theClass.getParentClass() + ") __this)";
            }
            blockForDef.isConstructor = true;
            ArrayList<CustomVariablesClass> classFields = theClass.getClassVariables();
            for (CustomVariablesClass classField : classFields) {
                if (classField.declaratorRightSide != null) {
                    System.out.println("CON CLASS FIELD DEFAULT");
                    System.out.println(classField.getDeclaratorRightSide());
                    String finalString = "";
                    if (classField.declaratorRightSideType == "string") {
                        finalString += "__this->" + classField.getName() + " = " + "__rt::literal(" + classField.getDeclaratorRightSide() + ")";
                    } else if (classField.declaratorRightSideType == "integer") {
                        finalString += "__this->" + classField.getName() + " = " + classField.getDeclaratorRightSide();
                    }
                    blockForDef.classLevelInitFields.add(finalString);
                    System.out.println(finalString);
                }
            }
            blockForDef.returnStatement = "return __this";
            this.defaultInIt.translatedBlock = blockForDef;

            //Process the methods
            for (CustomMethodClass method : theClass.getMethods()) {
                cppMethodImplementation methodImp = new cppMethodImplementation(method, this.className, theClass);
                this.cppMethodImplementations.add(methodImp);

                //Check if the class overrides the default init in its methods
                if(method.getName() == "__init" && method.getParameters().size() == 0){
                    //if so
                    this.defaultInIt = null;
                }
            }

            System.out.println("DEFAULT INIT CHECK BEGIN");
            System.out.println(this.defaultInIt);
            if(this.defaultInIt != null){
                System.out.println(this.defaultInIt.name);
                System.out.println(this.defaultInIt.translatedBlock.deafultConsturctorCall);
                for (String field : this.defaultInIt.translatedBlock.classLevelInitFields){
                    System.out.println(field);
                }
            }
            System.out.println("DEFAULT INIT CHECK END");
        }
    }


    // If newArrayExpression it has , check concrete dimensions
    public static class CustomFieldDeclaration{

        int position;
        boolean isArray;
        boolean isClass;
        String fieldDeclarationLine;
        String allModifiers = "";
        String varType = "";
        String declaratorVar = "";
        String declaratorVal = "";

        ArrayList<String> mainFileLines;

        public CustomFieldDeclaration(Node fieldDec, int position) {

            mainFileLines = new ArrayList<String>();
            this.position = position;

            String qualifiedIdentifier = "";
            System.out.println("$fd " + fieldDec);
            for (int i = 0; i < fieldDec.size(); i++) {
                if (fieldDec.getNode(i).getName().equals("Modifiers")) {
                    System.out.println("In moddy");
                    Node modifiers = fieldDec.getNode(i);
                    // get all modifiers
                    for (int m = 0; m < modifiers.size(); m++ ){
                        allModifiers += modifiers.getString(m);
                    }
                }

                if (fieldDec.getNode(i).getName().equals("Type")) {
                    System.out.println("In type");
                    Node getType = fieldDec.getNode(i);
                    if (getType.getNode(0) == null){continue;}
                    if (!getType.getNode(0).isEmpty()){
                        varType = getType.getNode(0).getString(0);
                    }
                }

                if (fieldDec.getNode(i).getName().equals("Declarators")) {
                    System.out.println("In declarators");
                    Node declarator = fieldDec.getNode(i).getNode(0);
                    declaratorVar = declarator.getString(0);
                    // if condition, the declarator is an array
                    if (declarator.getNode(2) != null){

                        Node expression = declarator.getNode(2);
                        String expressionName = expression.getName();

                        System.out.println("expressionName " + expressionName);

                        if (expressionName == "SelectionExpression"){
                            // translation: ->
                            //res = processNameNode(n.getNode(0)) + "->" + n.getString(1);
                        }
                        else if (expressionName == "SubscriptExpression") {
                            Node subscriptExpression = declarator.getNode(2);
                            System.out.println("$sub1 " + subscriptExpression);

                            if (!subscriptExpression.getNode(0).getName().equals("SubscriptExpression")) {
                                System.out.println("$sub2 " + subscriptExpression);

                                //System.out.println("$idk2 " + subscriptExpression.getNode(0).getNode(0));
                                System.out.println("$sub3 " + subscriptExpression);

                                declaratorVal += "[" + subscriptExpression.getNode(1).getString(0) + "]";

                            } else {
                                subscriptExpression = declarator.getNode(2).getNode(0);
                                //System.out.println("$sub1 " + subscriptExpression);
                                System.out.println("$vvv " + subscriptExpression);
                                System.out.println("$v1 " + declaratorVal);
                                declaratorVal += "[" + subscriptExpression.getNode(0).getString(0) + "]";
                                declaratorVal += "[" + subscriptExpression.getNode(1).getString(0) + "]";
                            }
                            // translation: (*var)[index]
                            //res = "(*" + processNameNode(n.getNode(0)) + ")[" + processNameNode(n.getNode(1)) + "]";
                        } else if (expressionName == "ThisExpression") {
                            // translation: __this
                            //res = "__this";
                        } else if (expressionName == "NewClassExpression") {
                            // translation: __class:__init
                            //fieldDeclarationLine = processNewClassExpression(expression);
                            System.out.println("fdc123 " + fieldDeclarationLine);

                            Node newClassExpression = declarator.getNode(2);

                            declaratorVal += newClassExpression.getNode(2).getString(0);


                            Node arguments = newClassExpression.getNode(3);

                            declaratorVal += "(";

                            String args = "";

                           //A a =  __A::__init(new __A(), __rt::literal("A"));
                            for (int a = 0; a <arguments.size(); a++){


                             // args +=  processArguments(arguments.getNode(a));


                            System.out.println("THEARGS " +  arguments.getNode(a).getString(0));

                               if (arguments.getNode(a).getName().equals("StringLiteral")){
                                   args += ", __rt::literal(" + arguments.getNode(a).getString(0);
                               }
                               else {
//
                                   args += "," + arguments.getNode(a).getString(0);
                               }

                            }

                            declaratorVal +=")";

                            System.out.println("argsprint " + args);

                           fieldDeclarationLine =  varType + " " +  declaratorVar + " =  __" + varType + "::__init(new __" + varType  + ""+ args + "))";
//                        fieldDeclarationLine = "__rt::Ptr<" +qualifiedIdentifier + ", __rt::object_policy> "+ declaratorVar + " = new " + declaratorValue;

                            continue;
//                            Node newClassExpression = declarator.getNode(2);
//                            System.out.println("$1217/1 \n" + newClassExpression);
//
//                            declaratorVal += newClassExpression.getNode(2).getString(0);
//                            System.out.println(declaratorVal);
//                            // check if the instantiated object has arguments
//                            System.out.println("$n11 " + newClassExpression);
//                            if (!newClassExpression.getNode(3).isEmpty()) {
//
//                                Node arguments = newClassExpression.getNode(3);
//
//                                declaratorVal += "(";
//                                for (int x = 0; x < arguments.size(); x++) {
//
//                                    if (arguments.getNode(x).getName().equals("PrimaryIdentifier")) {
//                                        declaratorVal += "__" + arguments.getNode(x).getString(0);
//
//                                    } else {
//                                        declaratorVal += arguments.getNode(x).getString(0);
//                                    }
//
//                                    if (x < arguments.size() - 1) {
//                                        declaratorVal += ",";
//
//                                    }
//
//                                }
//                                declaratorVal += ")";
//
//
//                            } else {
//                                declaratorVal += "()";
//                            }
                            // end of check if instantiated object has arguments


                        } else if (expressionName == "CastExpression") {
                            // translation: no difference
                            //res = processCastExpression(n);
                        } else if (expressionName == "AdditiveExpression") {
                            // translation: no difference
                            //res = processNameNode(n.getNode(0)) + " + " + processNameNode(n.getNode(2));
                        } else if (expressionName == "MultiplicativeExpression") {
                            // translation: no difference
                            //res = processNameNode(n.getNode(0)) + " * " + processNameNode(n.getNode(2));
                        } else if (expressionName == "Expression") {
                            // translation: no difference
                            //res = processNameNode(n.getNode(0)) + " = " + processNameNode(n.getNode(2));
                        } else if (expressionName == "CallExpression") {
                            // translation: ->__vptr->methodCall
                            //res = processCallExpression(n);
                        }  else if (expressionName == "NewArrayExpression"){
                            System.out.println("anexpression1");

                            varType = "__rt::Ptr<" + varType + ", __rt::array_policy>";

                            declaratorVal += " new ";
                            declaratorVal += expression.getNode(0).getString(0);

                            Node concreteDimensions = expression.getNode(1);

                            System.out.println("expressurself " + expression);
                            System.out.println("dimsize " + concreteDimensions.size());
                            for (int d = 0; d < concreteDimensions.size(); d++){
                                declaratorVal += "[" + concreteDimensions.getNode(d).getString(0) + "]";
                            }
                        } // end of NewArrayExpression
                        // else can be integer literals and other primitive types
                        else{
                            declaratorVal += declarator.getNode(2).getString(0);
                        }

                        fieldDeclarationLine  = varType + " " + declaratorVar + " = " + declaratorVal;
                        System.out.println("newfielddec22 " + fieldDeclarationLine);
                    }
                    else{
                        // there is no declaratorValue
                        declaratorVar = declarator.getString(0);
                        fieldDeclarationLine = varType + " " + declaratorVar;
                    }
                }
            }
        }



//
//
//
//            } // end of get Declarators
        } // end of CustomFieldDeclaration Constructor


    public static class CustomForLoop{
        int positon;
        TranslatedBlock forLoopsTranslatedBlock;
        String forLoopDecLine = ""; // <- e.g. for(int i = 0; i < as.length; i++)

        public CustomForLoop(Node forLoopNode, int position, CustomClassObject theForLoopsClass){
            this.positon = position;
            System.out.println("this is for loop12345 " + forLoopNode);
            String loopIteratorType = "";
            String declaratorVar = "";
            String declaratorVal = "";
            String fullRelationalExpression = "";
            String rightHandVar = "";
            String incrementor;
            String postfixExpression = "";

            System.out.println("GETITSI " + forLoopNode.getNode(0).size());
            for (int i = 0; i < forLoopNode.getNode(0).size(); i++) {
                System.out.println("ello1234 "+ forLoopNode.getNode(0).getNode(i));

                if (forLoopNode.getNode(0).getNode(i).getName().equals("Type")){
                    System.out.println("$FOR TYPE");
                    Node getType = forLoopNode.getNode(0).getNode(i);
                    loopIteratorType = getType.getNode(0).getString(0);
                }

                if (forLoopNode.getNode(0).getNode(i).getName().equals("Declarators")){
                    System.out.println("$FOR DEC");
                    Node declarator = forLoopNode.getNode(0).getNode(i).getNode(0);
                    declaratorVar = declarator.getString(0);
                    declaratorVal = declarator.getNode(2).getString(0);
                }
                if (forLoopNode.getNode(0).getNode(i).getName().equals("RelationalExpression")){
                    System.out.println("$FOR RELATIONAL");
                    Node relationalExpression = forLoopNode.getNode(0).getNode(i);
                    String primaryId = relationalExpression.getNode(0).getString(0);
                    String operator = relationalExpression.getString(1);
                    Node selectionExpressionNode =  relationalExpression.getNode(2);
                    System.out.println("selectionExpressionNode123 " + selectionExpressionNode);
                    String selectionExpression = "";
                    if (selectionExpressionNode.getNode(0).getName().equals("SubscriptExpression")){
                        Node subscriptExpression = selectionExpressionNode.getNode(0);
                        selectionExpression += subscriptExpression.getNode(0).getString(0);
                        for (int s = 1; s < subscriptExpression.size(); s++){
                            selectionExpression += "[" + subscriptExpression.getNode(s).getString(0) + "]";
                        }
                        //"(*" + selectionExpressionNode.getNode(0).getNode(0).getString(0) + ")[" + selectionExpressionNode.getNode(0).getNode(0).getString(1) + "]";
                    }else {
                        selectionExpression = selectionExpressionNode.getNode(0).getString(0);
                    }
                    String lengthField = "";
                    if (selectionExpressionNode.getString(1) != null) {
                        lengthField = "." + selectionExpressionNode.getString(1);
                    }
                    fullRelationalExpression += primaryId + " " + operator + " " + selectionExpression + lengthField;
                }
                if (forLoopNode.getNode(0).getNode(i).getName().equals("ExpressionList")){
                    System.out.println("$FOR EXPRESSION");
                    Node expressionList = forLoopNode.getNode(0).getNode(i);
                    Node postfixExpressionNode = expressionList.getNode(0);
                     postfixExpression = postfixExpressionNode.getNode(0).getString(0) + postfixExpressionNode.getString(1);
                }
            } // end of get for loop header
            this.forLoopDecLine = "for (" + loopIteratorType + " " +  declaratorVar + " = " + declaratorVal  + "; " + fullRelationalExpression + "; " + postfixExpression + ")";
            System.out.println("fullForLoop1234678 " + forLoopDecLine);
            for (int i = 0; i < forLoopNode.size(); i++) {
                //Use this to find the for loops block
                if(forLoopNode.getNode(i).getName().equals("Block")){
                    //This is the for loops block
                    this.forLoopsTranslatedBlock = new TranslatedBlock(forLoopNode.getNode(i), false, theForLoopsClass);
                }
            }
        }
    }

    public static class CustomWhileLoop{
        int position;
        TranslatedBlock whileLoopTranslatedBlock;
        String whileLoopDeclarator = "while ";
        String conditional = "";
        String rhsVar = "";

        public CustomWhileLoop(Node whileLoopNode, int position, CustomClassObject theWhileLoopsClass){
            this.position = position;

            //PARSE WHILE LOOP HEADER
            System.out.println("whiley " + whileLoopNode);

            String primaryId = "";
            Node relationalExpressionNode = whileLoopNode.getNode(0);

            primaryId = relationalExpressionNode.getNode(0).getString(0);
            conditional = relationalExpressionNode.getString(1);
            rhsVar = relationalExpressionNode.getNode(2).getString(0);
            whileLoopDeclarator += "(" + primaryId +" " + conditional + " "  + rhsVar +")";

            System.out.println("whileLoop124 " + whileLoopDeclarator);

            for (int i = 0; i < whileLoopNode.size(); i++) {
                //Use this to find the for loops block
                if(whileLoopNode.getNode(i).getName().equals("Block")){
                    //This is the for loops block
                    this.whileLoopTranslatedBlock = new TranslatedBlock(whileLoopNode.getNode(i), false, theWhileLoopsClass);
                }
            }
        }
    }

    public static class CustomBlockDec{
        int positon;
        TranslatedBlock customBlockDecTranslatedBlock;
        public CustomBlockDec(Node blockNode, int positon, CustomClassObject theBlocksClass){
            this.positon = positon;
            this.customBlockDecTranslatedBlock = new TranslatedBlock(blockNode, false, theBlocksClass);
        }
    }

    public static class TranslatedBlock {
        // blocks have field declarations
        // Expression statements

        ArrayList<CustomFieldDeclaration> fieldDeclarations;
        public ArrayList<CustomFieldDeclaration> getFieldDeclarations() {
            return fieldDeclarations;
        }
        ArrayList<CustomExpressionStatement> expressionStatements;
        ArrayList<CustomForLoop> forLoops;
        ArrayList<CustomWhileLoop> whileLoops;
        ArrayList<CustomBlockDec> blockDecs;

        String returnStatement = "";

        //Constructor properties
        boolean isConstructor;
        String deafultConsturctorCall;
        ArrayList<String> classLevelInitFields;

        public TranslatedBlock(){
            //Fields for standared method block
            fieldDeclarations = new ArrayList<CustomFieldDeclaration>();
            expressionStatements = new ArrayList<CustomExpressionStatement>();
            forLoops = new ArrayList<CustomForLoop>();
            whileLoops = new ArrayList<CustomWhileLoop>();
            blockDecs = new ArrayList<CustomBlockDec>();
        };

        public TranslatedBlock(Node b, boolean flag, CustomClassObject theMethodsClass) {

            //If this is a constuctor handle the deafult/explcit constructor call
            //e.g. _Object::__init((Object) __this); OR __A::__init((A) __this, x1);
            this.isConstructor = flag;
            this.classLevelInitFields = new ArrayList<String>();
            this.deafultConsturctorCall = "__Object::__init((Object) __this)";

            //Fields for standared method block
            fieldDeclarations = new ArrayList<CustomFieldDeclaration>();
            expressionStatements = new ArrayList<CustomExpressionStatement>();
            forLoops = new ArrayList<CustomForLoop>();
            whileLoops = new ArrayList<CustomWhileLoop>();
            blockDecs = new ArrayList<CustomBlockDec>();

            for (int i = 0; i < b.size(); i++) {
                if (b.getNode(i).getName().equals("FieldDeclaration")) {
                    CustomFieldDeclaration fd = new CustomFieldDeclaration(b.getNode(i), i);
                    this.fieldDeclarations.add(fd);
                    System.out.println("fdline " + fd.fieldDeclarationLine);
                }
                else if (b.getNode(i).getName().equals("ExpressionStatement")) {
                    Node curNode = b.getNode(i);
                    if (curNode.getNode(0).getName().equals("CallExpression")) {
                        if (curNode.getNode(0).getString(2).equals("super")) {;
                            continue;
                        }
                    }
                    CustomExpressionStatement ex = new CustomExpressionStatement(b.getNode(i), i);
                    this.expressionStatements.add(ex);
                    System.out.println("NODE\n " + b.getNode(i));
                }
                else if (b.getNode(i).getName().equals("ForStatement")){
                    //For loop
                    CustomForLoop forlp = new CustomForLoop(b.getNode(i), i, theMethodsClass);
                    this.forLoops.add(forlp);
                }
                else if(b.getNode(i).getName().equals("WhileStatement")){
                    //While loop

                    CustomWhileLoop whilelp = new CustomWhileLoop((b.getNode(i)), i, theMethodsClass);
                    this.whileLoops.add(whilelp);
                }
                else if(b.getNode(i).getName().equals("Block")){
                    //block within a blokc
                    CustomBlockDec blocDec = new CustomBlockDec(b.getNode(i), i, theMethodsClass);
                    this.blockDecs.add(blocDec);
                }
                else if (b.getNode(i).getName() == "ReturnStatement") {
                    this.returnStatement = "return " + processNameNode(b.getNode(i).getNode(0));
                }
            }//End of for loop for block

            //Constructor helper stuff levae this at the end of the class
            //Handle Constructor Stuff
            if (this.isConstructor) {
                //Set return type to this
                this.returnStatement = "return __this";
                //Check if the clas extends object. If not then leave the init call to be Object
                if(theMethodsClass.getParentClass() != "None"){
                    this.deafultConsturctorCall = "__" + theMethodsClass.getParentClass() + "::__init((" + theMethodsClass.getParentClass() + ") __this)";
                }
                //First check what type of default constructor is called by going through the block
                String superOrThis = "";
                for (int k = 0; k < b.size(); k++) {
                    //Find if there is super etc..
                    if (b.getNode(k).getName().equals("ExpressionStatement")) {
                        if (b.getNode(k).getNode(0).getName().equals("CallExpression")) {
                            //Get the call expression node
                            Node callExpression = b.getNode(k).getNode(0);
                            if (callExpression.getString(2).equals("super")) {
                                //Super is called
                                String arguments = "";
                                Node argumentNode = callExpression.getNode(3);
                                for (int g = 0; g < argumentNode.size(); g++) {
                                    //Go through the arguments
                                    arguments += ", " + argumentNode.getNode(g).getString(0);
                                }
                                deafultConsturctorCall = "__" + theMethodsClass.getParentClass() + "::__init((" + theMethodsClass.getParentClass() + ") __this" + arguments + ")";
                            } else if (callExpression.getString(2).equals("this")) {
                                //This Call
                                deafultConsturctorCall = "__init(__this)";
                            }
                        }
                    }
                }

                //Handle Class level field InIts
                //Get the class level fields
                //TEST 003, 006, 007, 008, 025, 017, 021, 024
                ArrayList<CustomVariablesClass> classFields = theMethodsClass.getClassVariables();
                for (CustomVariablesClass classField : classFields) {
                    if(classField.declaratorRightSide != null){
                        System.out.println("CON CLASS FIELD INIT");
                        System.out.println(classField.getDeclaratorRightSide());
                        String finalString = "";
                        if (classField.declaratorRightSideType == "string"){
                            finalString += "__this->" + classField.getName() + " = " + "__rt::literal(" + classField.getDeclaratorRightSide() + ")";
                        }
                        else if(classField.declaratorRightSideType == "integer"){
                            finalString += "__this->" + classField.getName() + " = " + classField.getDeclaratorRightSide();
                        }
                        this.classLevelInitFields.add(finalString);
                        System.out.println(finalString);
                    }
                }

                System.out.println("THE CONSTRUCTOR CALL123 IN CONSTRUCTOR BLOCK BEGIN");
                System.out.println(deafultConsturctorCall);
                for (String field : this.classLevelInitFields){
                    System.out.println(field);
                }
                System.out.println("THE CONSTRUCTOR CALL123 IN CONSTRUCTOR BLOCK END");

            }//End of if constructor statement

        }//END OF Translate Block Constructor
    }//End of TranslatedBlock class


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
                    DefaultType = "__rt::literal(\"\")";
                    break;

                default:
                    DefaultType = "__rt::null()";
                    break;
            }
            return DefaultType;
        }
    }

    public static class cppMethodImplementation{
        String returnType;
        String name;
        String params;

        //Block stuff
        Node theBlock;
        TranslatedBlock translatedBlock;

        //See if the method is a constructor
        boolean isConstuctor = false;

        public cppMethodImplementation(){};

        public cppMethodImplementation(CustomMethodClass methodClass, String className, CustomClassObject theMethodsClass){
            CppDataLayout.typeTranslate typeTranslate = new CppDataLayout.typeTranslate();
            this.returnType = typeTranslate.translateType(methodClass.getReturnType());
            // name = __className
            this.name = this.returnType + " __" + className + "::" + methodClass.getName();
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
                this.returnType = "__this";
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

    public static String processNewClassExpression(Node newClassExpression) {
        String className = newClassExpression.getNode(2).getString(0);
        String ret = "__" + className + "::__init(new __" + className + "()";
        String arguments = "";
        if (newClassExpression.getNode(3) != null) {
            arguments = processArguments(newClassExpression.getNode(3));
        }
        if (arguments.length() > 0) {
            ret += ", ";
            ret += arguments;
        }
        ret += ")";
        return ret;
    }

    public static String processArguments(Node arguments) {
        String ret = "";
        for (int x = 0; x < arguments.size(); x++) {
            if (x != 1) {
                ret += ", " + processNameNode(arguments.getNode(x));
            } else {
                ret += processNameNode(arguments.getNode(x));
            }

        }
        return ret;

    }
    public static String processCastExpression(Node n) {
        String ret = "__rt::java_cast<" + n.getNode(0).getNode(0).getString(0) + ">(";
        ret += processNameNode(n.getNode(1)) + ")";
        return ret;
    }


    public static boolean isPrint(Node n) {
        System.out.println("isPrint1233 " + n);

            if (n.getNode(0).getName() == "SelectionExpression") {
                if (n.getNode(0).getNode(0).getName() == "PrimaryIdentifier") {
                    if (n.getNode(0).getNode(0).getString(0).equals("System")) {
                        return true;
                    }
                }
            }
        return false;
    }

    public static String processCallExpression(Node n, int i) {
        String arguments = "";
        if (n.getNode(3) != null) {
            arguments = processArguments(n.getNode(3));
        }
        if (isPrint(n)) {
            // may want to consider differentiation between print and println
            return "std::cout << " + arguments.substring(2,arguments.length()) + " << std::endl";
        }


        String methodName = n.getString(2);
        String ret = "({";
        String callTo;
        if (n.getNode(0).getName().equals("CallExpression")) {
            String tmpCallTo = processCallExpression(n.getNode(0), i + 1);
            String iter = Integer.toString(i);
            String tmp = "tmp" + iter;
            ret += "Object " + tmp + " = " + tmpCallTo + "; ";
            ret += "__rt::checkNotNull(" + tmp + "); ";
            callTo = tmp;
        } else {
            callTo = processNameNode(n.getNode(0));
            ret += "__rt::checkNotNull(" + callTo + "); ";
        }
        ret += callTo + "->__vptr->" + methodName + "(" + callTo + arguments + ");})";
        return ret;
    }

    public static String processNameNode(Node n) {
        String res = "";
        boolean justString = n.getName() == "PrimaryIdentifier" || n.getName() == "IntegerLiteral";
        if (justString) {
            res = n.getString(0);
        } else if (n.getName() == "SelectionExpression"){
            // translation: ->
            res = processNameNode(n.getNode(0)) + "->" + n.getString(1);
        } else if (n.getName() == "SubscriptExpression") {
            // translation: (*var)[index]
            res = "(*" + processNameNode(n.getNode(0)) + ")[" + processNameNode(n.getNode(1)) + "]";
        } else if (n.getName() == "ThisExpression") {
            // translation: __this
            res = "__this";
        } else if (n.getName() == "NewClassExpression") {
            // translation: __class:__init
            res = processNewClassExpression(n);
        } else if (n.getName() == "CastExpression") {
            // javalangcast thing
            res = processCastExpression(n);
        } else if (n.getName() == "AdditiveExpression") {
            // translation: no difference
            res = processNameNode(n.getNode(0)) + " + " + processNameNode(n.getNode(2));
        } else if (n.getName() == "MultiplicativeExpression") {
            // translation: no difference
            res = processNameNode(n.getNode(0)) + " * " + processNameNode(n.getNode(2));
        } else if (n.getName() == "Expression") {
            // translation: no difference
            res = processNameNode(n.getNode(0)) + " = " + processNameNode(n.getNode(2));
        } else if (n.getName() == "CallExpression") {
            // translation: ->__vptr->methodCall with bracket stuff
            res = processCallExpression(n, 0);
        } else if (n.getName() == "StringLiteral") {
            // translation: __rt::literal(<string>)
            res = "__rt::literal(" + n.getString(0) + ")";
        }
        return res;
    }

    public static class CustomExpressionStatement{
        String expression;
        int position;

        public CustomExpressionStatement(Node sonNode, int pos) {
            this.position = pos;
            this.expression = processNameNode(sonNode.getNode(0));
            System.out.println("=====================================");
            System.out.println("ExpressionStatement");
            System.out.println(this.expression);
            System.out.println("=====================================");
        }
    }
}

