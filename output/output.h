#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace test010 {

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

static C __init();

String c;

static Class __class();
static __C_VT __vtable;
};


struct __Test010;
struct __Test010_VT;
typedef __Test010* Test010;

struct __Test010 { 
__Test010_VT* __vptr;
__Test010();

static void main(Test010,String);
static Test010 __init();

static Class __class();
static __Test010_VT __vtable;
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
hashCode((int32_t (*)(A)) &__A::hashCode),
getClass((Class (*)(A)) &__A::getClass),
equals((boolean (*)(A, Object)) &_A::equals),
setA(&__A::setA),
printOther(&__A::printOther),
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

__B1_VT()
 : __is_a(__B1::__class()),
setA((void (*)(B1)) &__B1::setA),
printOther((void (*)(B1)) &__B1::printOther),
toString((String (*)(B1)) &__B1::toString),
hashCode((int32_t (*)(B1)) &__B1::hashCode),
getClass((Class (*)(B1)) &__B1::getClass),
equals((boolean (*)(B1, Object)) &_B1::equals)
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

__B2_VT()
 : __is_a(__B2::__class()),
setA((void (*)(B2)) &__B2::setA),
printOther((void (*)(B2)) &__B2::printOther),
toString((String (*)(B2)) &__B2::toString),
hashCode((int32_t (*)(B2)) &__B2::hashCode),
getClass((Class (*)(B2)) &__B2::getClass),
equals((boolean (*)(B2, Object)) &_B2::equals)
{
}
};



struct __C_VT { 
Class __is_a;
void (*setA) (C);
void (*printOther) (C);
String (*toString) (C);
int32_t (*hashCode) (C);
Class (*getClass) (C);
boolean (*equals) (C, Object);

__C_VT()
 : __is_a(__C::__class()),
setA((void (*)(C)) &__C::setA),
printOther((void (*)(C)) &__C::printOther),
toString((String (*)(C)) &__C::toString),
hashCode((int32_t (*)(C)) &__C::hashCode),
getClass((Class (*)(C)) &__C::getClass),
equals((boolean (*)(C, Object)) &_C::equals)
{
}
};



struct __Test010_VT { 
Class __is_a;
int32_t (*hashCode) (Test010);
Class (*getClass) (Test010);
String (*toString) (Test010);
boolean (*equals) (Test010, Object);
void (*main) (Test010);

__Test010_VT()
 : __is_a(__Test010::__class()),
hashCode((int32_t (*)(Test010)) &__Test010::hashCode),
getClass((Class (*)(Test010)) &__Test010::getClass),
toString((String (*)(Test010)) &__Test010::toString),
equals((boolean (*)(Test010, Object)) &_Test010::equals),
main(&__Test010::main)
{
}
};


}
}
