#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace CustomTests {

struct __A;
struct __A_VT;
typedef __A* A;

struct __A { 
__A_VT* __vptr;
__A();

static void setA(A,String);
static void printOther(A,A);
static String toString(A);
static A __init();

String a;

static Class __class();
static __A_VT __vtable;
};


struct __B1;
struct __B1_VT;
typedef __B1* B1;

struct __B1 { 
__B1_VT* __vptr;
__B1();

static void helloWorld(B1);
static B1 __init();

String b;

static Class __class();
static __B1_VT __vtable;
};


struct __B2;
struct __B2_VT;
typedef __B2* B2;

struct __B2 { 
__B2_VT* __vptr;
__B2();

static void goodbye(B2);
static void helloWorld(B2);
static void helloJohn(B2);
static B2 __init();

String b;

static Class __class();
static __B2_VT __vtable;
};


struct __C;
struct __C_VT;
typedef __C* C;

struct __C { 
__C_VT* __vptr;
__C();

static void helloDave(C);
static String toString(C);
static C __init();

String c;

static Class __class();
static __C_VT __vtable;
};


struct __CustomTest1;
struct __CustomTest1_VT;
typedef __CustomTest1* CustomTest1;

struct __CustomTest1 { 
__CustomTest1_VT* __vptr;
__CustomTest1();

static void main(CustomTest1,String);
static CustomTest1 __init();

static Class __class();
static __CustomTest1_VT __vtable;
};




struct __A_VT { 
Class __is_a;
int32_t (*hashCode) (A);
Class (*getClass) (A);
boolean (*equals) (A, Object);
void (*setA) (A);
void (*printOther) (A);
String (*toString) (A);

__A_VT()
 : __is_a(__A::__class()),
hashCode((int32_t (*)(A)) &__Object::hashCode),
getClass((Class (*)(A)) &__Object::getClass),
equals((boolean (*)(A, Object)) &__Object::equals),
setA((void (*)(A)) &__A::setA),
printOther((void (*)(A)) &__A::printOther),
toString(&__A::toString)
{
}
};



struct __B1_VT { 
Class __is_a;
void (*setA) (B1);
void (*printOther) (B1);
String (*toString) (B1);
int32_t (*hashCode) (B1);
Class (*getClass) (B1);
boolean (*equals) (B1, Object);
void (*helloWorld) (B1);

__B1_VT()
 : __is_a(__B1::__class()),
setA((void (*)(B1)) &__A::setA),
printOther((void (*)(B1)) &__A::printOther),
toString((String (*)(B1)) &__A::toString),
hashCode((int32_t (*)(B1)) &__Object::hashCode),
getClass((Class (*)(B1)) &__Object::getClass),
equals((boolean (*)(B1, Object)) &__Object::equals),
helloWorld((void (*)(B1)) &__B1::helloWorld)
{
}
};



struct __B2_VT { 
Class __is_a;
void (*setA) (B2);
void (*printOther) (B2);
String (*toString) (B2);
int32_t (*hashCode) (B2);
Class (*getClass) (B2);
boolean (*equals) (B2, Object);
void (*goodbye) (B2);
void (*helloJohn) (B2);
void (*helloWorld) (B2);

__B2_VT()
 : __is_a(__B2::__class()),
setA((void (*)(B2)) &__A::setA),
printOther((void (*)(B2)) &__A::printOther),
toString((String (*)(B2)) &__A::toString),
hashCode((int32_t (*)(B2)) &__Object::hashCode),
getClass((Class (*)(B2)) &__Object::getClass),
equals((boolean (*)(B2, Object)) &__Object::equals),
goodbye((void (*)(B2)) &__B2::goodbye),
helloJohn((void (*)(B2)) &__B2::helloJohn),
helloWorld(&__B2::helloWorld)
{
}
};



struct __C_VT { 
Class __is_a;
void (*goodbye) (C);
void (*helloWorld) (C);
void (*helloJohn) (C);
void (*setA) (C);
void (*printOther) (C);
int32_t (*hashCode) (C);
Class (*getClass) (C);
boolean (*equals) (C, Object);
void (*helloDave) (C);
String (*toString) (C);

__C_VT()
 : __is_a(__C::__class()),
goodbye((void (*)(C)) &__B2::goodbye),
helloWorld((void (*)(C)) &__B2::helloWorld),
helloJohn((void (*)(C)) &__B2::helloJohn),
setA((void (*)(C)) &__A::setA),
printOther((void (*)(C)) &__A::printOther),
hashCode((int32_t (*)(C)) &__Object::hashCode),
getClass((Class (*)(C)) &__Object::getClass),
equals((boolean (*)(C, Object)) &__Object::equals),
helloDave((void (*)(C)) &__C::helloDave),
toString(&__C::toString)
{
}
};



struct __CustomTest1_VT { 
Class __is_a;
int32_t (*hashCode) (CustomTest1);
Class (*getClass) (CustomTest1);
String (*toString) (CustomTest1);
boolean (*equals) (CustomTest1, Object);
void (*main) (CustomTest1);

__CustomTest1_VT()
 : __is_a(__CustomTest1::__class()),
hashCode((int32_t (*)(CustomTest1)) &__Object::hashCode),
getClass((Class (*)(CustomTest1)) &__Object::getClass),
toString((String (*)(CustomTest1)) &__Object::toString),
equals((boolean (*)(CustomTest1, Object)) &__Object::equals),
main((void (*)(CustomTest1)) &__CustomTest1::main)
{
}
};


}
}
