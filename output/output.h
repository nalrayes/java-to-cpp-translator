#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test016 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

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
      void (*printOther_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        printOther_A(&__A::printOther_A) {}
    };

    struct __B;
    struct __B_VT;
    typedef __B* B;
    
    struct __B { 
      
      __B_VT* __vptr;
      
      __B();

      public B some;

      static void printOther_A(B,A);
      static String toString(B);
      static B __init();
      static Class __class();

      static __B_VT __vtable;
    };

    struct __B_VT { 
      Class __is_a;

      int32_t (*hashCode) (B);
      Class (*getClass) (B);
      bool (*equals) (B, Object);
      String (*toString) (B);
      void (*printOther_A) (B, A);

      __B_VT()
      : __is_a(__B::__class()),
        hashCode((int32_t (*)(B)) &__Object::hashCode),
        getClass((Class (*)(B)) &__Object::getClass),
        equals((bool (*)(B, Object)) &__Object::equals),
        printOther_A(&__B::printOther_A),
        toString(&__B::toString) {}
    };

    struct __Test016;
    struct __Test016_VT;
    typedef __Test016* Test016;
    
    struct __Test016 { 
      
      __Test016_VT* __vptr;
      
      __Test016();

      static void main_String(Test016,String);
      static Test016 __init();
      static Class __class();

      static __Test016_VT __vtable;
    };

    struct __Test016_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test016);
      Class (*getClass) (Test016);
      String (*toString) (Test016);
      bool (*equals) (Test016, Object);

      __Test016_VT()
      : __is_a(__Test016::__class()),
        hashCode((int32_t (*)(Test016)) &__Object::hashCode),
        getClass((Class (*)(Test016)) &__Object::getClass),
        toString((String (*)(Test016)) &__Object::toString),
        equals((bool (*)(Test016, Object)) &__Object::equals),
        main_String(&__Test016::main_String) {}
    };

  }
}
