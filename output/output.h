#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace test001 {

struct __A;
struct __A_VT;
typedef __A* A;

struct __A { 
__A_VT* __vptr;
__A();

static Class __class();
static __A_VT __vtable;
};


  
static String toString(A
);
static A __init(
);

}
struct __A_VT { 
Class __is_a;
int32_t (*hashCode) (A);
Class (*getClass) (A);
boolean (*equals) (A, Object);
String (*toString) (A);

__A_VT()
 : __is_a(__A::__class()),
hashCode((int32_t (*)(A)) &__A::hashCode),
getClass((Class (*)(A)) &__A::getClass),
equals((boolean (*)(A, Object)) &_A::equals),
toString(&__A::toString)
{
}
};


struct __Test001;
struct __Test001_VT;
typedef __Test001* Test001;

struct __Test001 { 
__Test001_VT* __vptr;
__Test001();

static Class __class();
static __Test001_VT __vtable;
};


    
static void main(Test001,String
);
static Test001 __init(
);

}
struct __Test001_VT { 
Class __is_a;
int32_t (*hashCode) (Test001);
Class (*getClass) (Test001);
String (*toString) (Test001);
boolean (*equals) (Test001, Object);
void (*main) (Test001);

__Test001_VT()
 : __is_a(__Test001::__class()),
hashCode((int32_t (*)(Test001)) &__Test001::hashCode),
getClass((Class (*)(Test001)) &__Test001::getClass),
toString((String (*)(Test001)) &__Test001::toString),
equals((boolean (*)(Test001, Object)) &_Test001::equals),
main(&__Test001::main)
{
}
};


}
}
