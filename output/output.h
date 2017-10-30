#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace CustomTests {

struct __A;

struct __A { 
__A();

void __setA(String);
void __printOther(A);
String __toString();
A __init();

String a;

};


struct __B1;

struct __B1 { 
__B1();

void __helloWorld();
B1 __init();

String b;

};


struct __B2;

struct __B2 { 
__B2();

void __goodbye();
void __helloWorld();
B2 __init();

String b;

};


struct __C;

struct __C { 
__C();

String __toString();
C __init();

String c;

};


struct __CustomTest1;

struct __CustomTest1 { 
__CustomTest1();

void __main(String);
CustomTest1 __init();

};



struct A;

struct A { 
int32_t (*hashCode)((A));
bool (*equals)((A));
Class (*getClass)((A));
String (*toString)((A));
void (*setA)(A);
void (*printOther)(A);
String (*toString)(A);

__A_VT()
 : __is_a(__A::__class()),
hashCode((int32_t (*)(A))_A &_Object::hashCode),
getClass((Class (*)(A))_A &_Object::getClass),
equals((boolean (*)(A))_A &_Object::equals),
setA((void (*)(A))_A &_A::setA),
printOther((void (*)(A))_A &_A::printOther),
toString(__A::toString)
};


struct B1;

struct B1 { 
int32_t (*hashCode)((B1));
bool (*equals)((B1));
Class (*getClass)((B1));
String (*toString)((B1));
void (*helloWorld)(B1);

__B1_VT()
 : __is_a(__B1::__class()),
setA((void (*)(B1))_B1 &_A::setA),
printOther((void (*)(B1))_B1 &_A::printOther),
toString((String (*)(B1))_B1 &_A::toString),
hashCode((int32_t (*)(B1))_B1 &_Object::hashCode),
getClass((Class (*)(B1))_B1 &_Object::getClass),
equals((boolean (*)(B1))_B1 &_Object::equals),
helloWorld((void (*)(B1))_B1 &_B1::helloWorld)
};


struct B2;

struct B2 { 
int32_t (*hashCode)((B2));
bool (*equals)((B2));
Class (*getClass)((B2));
String (*toString)((B2));
void (*goodbye)(B2);
void (*helloWorld)(B2);

__B2_VT()
 : __is_a(__B2::__class()),
setA((void (*)(B2))_B2 &_A::setA),
printOther((void (*)(B2))_B2 &_A::printOther),
toString((String (*)(B2))_B2 &_A::toString),
hashCode((int32_t (*)(B2))_B2 &_Object::hashCode),
getClass((Class (*)(B2))_B2 &_Object::getClass),
equals((boolean (*)(B2))_B2 &_Object::equals),
goodbye((void (*)(B2))_B2 &_B2::goodbye),
helloWorld(__B2::helloWorld)
};


struct C;

struct C { 
int32_t (*hashCode)((C));
bool (*equals)((C));
Class (*getClass)((C));
String (*toString)((C));
String (*toString)(C);

__C_VT()
 : __is_a(__C::__class()),
goodbye((void (*)(C))_C &_B2::goodbye),
helloWorld((void (*)(C))_C &_B2::helloWorld),
setA((void (*)(C))_C &_A::setA),
printOther((void (*)(C))_C &_A::printOther),
hashCode((int32_t (*)(C))_C &_Object::hashCode),
getClass((Class (*)(C))_C &_Object::getClass),
equals((boolean (*)(C))_C &_Object::equals),
toString(__C::toString)
};


struct CustomTest1;

struct CustomTest1 { 
int32_t (*hashCode)((CustomTest1));
bool (*equals)((CustomTest1));
Class (*getClass)((CustomTest1));
String (*toString)((CustomTest1));
void (*main)(CustomTest1);

__CustomTest1_VT()
 : __is_a(__CustomTest1::__class()),
hashCode((int32_t (*)(CustomTest1))_CustomTest1 &_Object::hashCode),
getClass((Class (*)(CustomTest1))_CustomTest1 &_Object::getClass),
toString((String (*)(CustomTest1))_CustomTest1 &_Object::toString),
equals((boolean (*)(CustomTest1))_CustomTest1 &_Object::equals),
main((void (*)(CustomTest1))_CustomTest1 &_CustomTest1::main)
};


}
}
