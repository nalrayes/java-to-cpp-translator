#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace CustomTests {

struct __A;
__A* A;

struct __A { 
__A();

void __setA(String);
void __printOther(A);
String __toString();
A __init();

String a;

};


struct __B1;
__B1* B1;

struct __B1 { 
__B1();

void __helloWorld();
B1 __init();

String b;

};


struct __B2;
__B2* B2;

struct __B2 { 
__B2();

void __goodbye();
void __helloWorld();
void __helloJohn();
B2 __init();

String b;

};


struct __C;
__C* C;

struct __C { 
__C();

void __helloDave();
String __toString();
C __init();

String c;

};


struct __CustomTest1;
__CustomTest1* CustomTest1;

struct __CustomTest1 { 
__CustomTest1();

void __main(String);
CustomTest1 __init();

};



struct __A_VT;

struct __A_VT { 
int32_t *(hashCode) (A);
Class *(getClass) (A);
boolean *(equals) (A);
void *(setA) (A);
void *(printOther) (A);
String *(toString) (A);

__A_VT()
 : __is_a(__A::__class()),
hashCode((int32_t (*)(A))_A &_Object::hashCode),
getClass((Class (*)(A))_A &_Object::getClass),
equals((boolean (*)(A))_A &_Object::equals),
setA((void (*)(A))_A &_A::setA),
printOther((void (*)(A))_A &_A::printOther),
toString(__A::toString)
{
}
};


struct __B1_VT;

struct __B1_VT { 
void *(setA) (B1);
void *(printOther) (B1);
String *(toString) (B1);
int32_t *(hashCode) (B1);
Class *(getClass) (B1);
boolean *(equals) (B1);
void *(helloWorld) (B1);

__B1_VT()
 : __is_a(__B1::__class()),
setA((void (*)(B1))_B1 &_A::setA),
printOther((void (*)(B1))_B1 &_A::printOther),
toString((String (*)(B1))_B1 &_A::toString),
hashCode((int32_t (*)(B1))_B1 &_Object::hashCode),
getClass((Class (*)(B1))_B1 &_Object::getClass),
equals((boolean (*)(B1))_B1 &_Object::equals),
helloWorld((void (*)(B1))_B1 &_B1::helloWorld)
{
}
};


struct __B2_VT;

struct __B2_VT { 
void *(setA) (B2);
void *(printOther) (B2);
String *(toString) (B2);
int32_t *(hashCode) (B2);
Class *(getClass) (B2);
boolean *(equals) (B2);
void *(goodbye) (B2);
void *(helloJohn) (B2);
void *(helloWorld) (B2);

__B2_VT()
 : __is_a(__B2::__class()),
setA((void (*)(B2))_B2 &_A::setA),
printOther((void (*)(B2))_B2 &_A::printOther),
toString((String (*)(B2))_B2 &_A::toString),
hashCode((int32_t (*)(B2))_B2 &_Object::hashCode),
getClass((Class (*)(B2))_B2 &_Object::getClass),
equals((boolean (*)(B2))_B2 &_Object::equals),
goodbye((void (*)(B2))_B2 &_B2::goodbye),
helloJohn((void (*)(B2))_B2 &_B2::helloJohn),
helloWorld(__B2::helloWorld)
{
}
};


struct __C_VT;

struct __C_VT { 
void *(goodbye) (C);
void *(helloWorld) (C);
void *(helloJohn) (C);
void *(setA) (C);
void *(printOther) (C);
int32_t *(hashCode) (C);
Class *(getClass) (C);
boolean *(equals) (C);
void *(helloDave) (C);
String *(toString) (C);

__C_VT()
 : __is_a(__C::__class()),
goodbye((void (*)(C))_C &_B2::goodbye),
helloWorld((void (*)(C))_C &_B2::helloWorld),
helloJohn((void (*)(C))_C &_B2::helloJohn),
setA((void (*)(C))_C &_A::setA),
printOther((void (*)(C))_C &_A::printOther),
hashCode((int32_t (*)(C))_C &_Object::hashCode),
getClass((Class (*)(C))_C &_Object::getClass),
equals((boolean (*)(C))_C &_Object::equals),
helloDave((void (*)(C))_C &_C::helloDave),
toString(__C::toString)
{
}
};


struct __CustomTest1_VT;

struct __CustomTest1_VT { 
int32_t *(hashCode) (CustomTest1);
Class *(getClass) (CustomTest1);
String *(toString) (CustomTest1);
boolean *(equals) (CustomTest1);
void *(main) (CustomTest1);

__CustomTest1_VT()
 : __is_a(__CustomTest1::__class()),
hashCode((int32_t (*)(CustomTest1))_CustomTest1 &_Object::hashCode),
getClass((Class (*)(CustomTest1))_CustomTest1 &_Object::getClass),
toString((String (*)(CustomTest1))_CustomTest1 &_Object::toString),
equals((boolean (*)(CustomTest1))_CustomTest1 &_Object::equals),
main((void (*)(CustomTest1))_CustomTest1 &_CustomTest1::main)
{
}
};


}
}
