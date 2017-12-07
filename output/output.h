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

      int32_t theInt;

      bool theBoolean;

      float theFloat;

      long theLong;

      short theShort;

      char theChar;

      double theDouble;

      byte theByte;

      A A;

      String a;

      static void setA_String(A,String);
      static void printOther_A(A,A);
      static String toString(A);
      static A __init();
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      bool (*equals) (A, Object);
      String (*toString) (A);
      void (*setA_String) (A, String);
      void (*printOther_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        equals((bool (*)(A, Object)) &__Object::equals),
        setA_String(&__A::setA_String),
        printOther_A(&__A::printOther_A),
        toString(&__A::toString) {}
    };

    struct __B1;
    struct __B1_VT;
    typedef __B1* B1;
    
    struct __B1 { 
      
      __B1_VT* __vptr;
      
      __B1();

      String b;

      A A;

      B1 B;

      static void helloWorld(B1);
      static B1 __init();
      static B1 __init(int32_t,int32_t);
      static B1 __init(A);
      static Class __class();

      static __B1_VT __vtable;
    };

    struct __B1_VT { 
      Class __is_a;

      int32_t (*hashCode) (B1);
      Class (*getClass) (B1);
      bool (*equals) (B1, Object);
      void (*setA_String) (B1, String);
      void (*printOther_A) (B1, A);
      String (*toString) (B1);
      void (*helloWorld) (B1);

      __B1_VT()
      : __is_a(__B1::__class()),
        setA_String((void (*)(B1)) &__A::setA_String),
        printOther_A((void (*)(B1)) &__A::printOther_A),
        toString((String (*)(B1)) &__A::toString),
        hashCode((int32_t (*)(B1)) &__Object::hashCode),
        getClass((Class (*)(B1)) &__Object::getClass),
        equals((bool (*)(B1, Object)) &__Object::equals),
        helloWorld(&__B1::helloWorld) {}
    };

    struct __B2;
    struct __B2_VT;
    typedef __B2* B2;
    
    struct __B2 { 
      
      __B2_VT* __vptr;
      
      __B2();

      String b;

      static void goodbye(B2);
      static void helloWorld(B2);
      static void helloJohn(B2);
      static B2 __init();
      static Class __class();

      static __B2_VT __vtable;
    };

    struct __B2_VT { 
      Class __is_a;

      int32_t (*hashCode) (B2);
      Class (*getClass) (B2);
      bool (*equals) (B2, Object);
      void (*setA_String) (B2, String);
      void (*printOther_A) (B2, A);
      String (*toString) (B2);
      void (*helloWorld) (B2);
      void (*goodbye) (B2);
      void (*helloJohn) (B2);

      __B2_VT()
      : __is_a(__B2::__class()),
        setA_String((void (*)(B2)) &__A::setA_String),
        printOther_A((void (*)(B2)) &__A::printOther_A),
        toString((String (*)(B2)) &__A::toString),
        hashCode((int32_t (*)(B2)) &__Object::hashCode),
        getClass((Class (*)(B2)) &__Object::getClass),
        equals((bool (*)(B2, Object)) &__Object::equals),
        goodbye(&__B2::goodbye),
        helloJohn(&__B2::helloJohn),
        helloWorld(&__B2::helloWorld) {}
    };

    struct __C;
    struct __C_VT;
    typedef __C* C;
    
    struct __C { 
      
      __C_VT* __vptr;
      
      __C();

      String c;

      static void helloDave(C);
      static String toString(C);
      static C __init();
      static Class __class();

      static __C_VT __vtable;
    };

    struct __C_VT { 
      Class __is_a;

      int32_t (*hashCode) (C);
      Class (*getClass) (C);
      bool (*equals) (C, Object);
      void (*setA_String) (C, String);
      void (*printOther_A) (C, A);
      void (*helloWorld) (C);
      void (*goodbye) (C);
      void (*helloWorld) (C);
      void (*helloJohn) (C);
      String (*toString) (C);
      void (*helloDave) (C);

      __C_VT()
      : __is_a(__C::__class()),
        goodbye((void (*)(C)) &__B2::goodbye),
        helloWorld((void (*)(C)) &__B2::helloWorld),
        helloJohn((void (*)(C)) &__B2::helloJohn),
        setA_String((void (*)(C)) &__A::setA_String),
        printOther_A((void (*)(C)) &__A::printOther_A),
        hashCode((int32_t (*)(C)) &__Object::hashCode),
        getClass((Class (*)(C)) &__Object::getClass),
        equals((bool (*)(C, Object)) &__Object::equals),
        helloDave(&__C::helloDave),
        toString(&__C::toString) {}
    };

    struct __CustomTest1;
    struct __CustomTest1_VT;
    typedef __CustomTest1* CustomTest1;
    
    struct __CustomTest1 { 
      
      __CustomTest1_VT* __vptr;
      
      __CustomTest1();

      static void main_String(CustomTest1,String);
      static CustomTest1 __init();
      static Class __class();

      static __CustomTest1_VT __vtable;
    };

    struct __CustomTest1_VT { 
      Class __is_a;

      int32_t (*hashCode) (CustomTest1);
      Class (*getClass) (CustomTest1);
      String (*toString) (CustomTest1);
      bool (*equals) (CustomTest1, Object);

      __CustomTest1_VT()
      : __is_a(__CustomTest1::__class()),
        hashCode((int32_t (*)(CustomTest1)) &__Object::hashCode),
        getClass((Class (*)(CustomTest1)) &__Object::getClass),
        toString((String (*)(CustomTest1)) &__Object::toString),
        equals((bool (*)(CustomTest1, Object)) &__Object::equals),
        main_String(&__CustomTest1::main_String) {}
    };

  }
}
