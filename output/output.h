#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test013 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      String a;

      static void setA_String(A,String);
      static void printOther_A(A,A);
      static A __init();
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);
      void (*setA_String) (A, String);
      void (*printOther_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        setA_String(&__A::setA_String),
        printOther_A(&__A::printOther_A) {}
    };

    struct __Test013;
    struct __Test013_VT;
    typedef __Test013* Test013;
    
    struct __Test013 { 
      
      __Test013_VT* __vptr;
      
      __Test013();

      static void main_String(Test013,String);
      static Test013 __init();
      static Class __class();

      static __Test013_VT __vtable;
    };

    struct __Test013_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test013);
      Class (*getClass) (Test013);
      String (*toString) (Test013);
      bool (*equals) (Test013, Object);

      __Test013_VT()
      : __is_a(__Test013::__class()),
        hashCode((int32_t (*)(Test013)) &__Object::hashCode),
        getClass((Class (*)(Test013)) &__Object::getClass),
        toString((String (*)(Test013)) &__Object::toString),
        equals((bool (*)(Test013, Object)) &__Object::equals),
        main_String(&__Test013::main_String) {}
    };

  }
}
