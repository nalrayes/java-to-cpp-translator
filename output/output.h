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

      String a;

      static void setA(A,String);
      static void printOther(A,A);
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
      void (*setA) (A);
      void (*printOther) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        equals((bool (*)(A, Object)) &__Object::equals),
        setA(&__A::setA),
        printOther(&__A::printOther),
        toString(&__A::toString) {}
    };

    struct __B1;
    struct __B1_VT;
    typedef __B1* B1;
    
    struct __B1 { 
      
      __B1_VT* __vptr;
      
      __B1();

      String b;

      static B1 __init();
      static Class __class();

      static __B1_VT __vtable;
    };

    struct __B1_VT { 
      Class __is_a;

      int32_t (*hashCode) (B1);
      Class (*getClass) (B1);
      bool (*equals) (B1, Object);
      void (*setA) (B1);
      void (*printOther) (B1);
      String (*toString) (B1);

      __B1_VT()
      : __is_a(__B1::__class()),
        setA((void (*)(B1)) &__A::setA),
        printOther((void (*)(B1)) &__A::printOther),
        toString((String (*)(B1)) &__A::toString),
        hashCode((int32_t (*)(B1)) &__Object::hashCode),
        getClass((Class (*)(B1)) &__Object::getClass),
        equals((bool (*)(B1, Object)) &__Object::equals) {}
    };

    struct __B2;
    struct __B2_VT;
    typedef __B2* B2;
    
    struct __B2 { 
      
      __B2_VT* __vptr;
      
      __B2();

      String b;

      static B2 __init();
      static Class __class();

      static __B2_VT __vtable;
    };

    struct __B2_VT { 
      Class __is_a;

      int32_t (*hashCode) (B2);
      Class (*getClass) (B2);
      bool (*equals) (B2, Object);
      void (*setA) (B2);
      void (*printOther) (B2);
      String (*toString) (B2);

      __B2_VT()
      : __is_a(__B2::__class()),
        setA((void (*)(B2)) &__A::setA),
        printOther((void (*)(B2)) &__A::printOther),
        toString((String (*)(B2)) &__A::toString),
        hashCode((int32_t (*)(B2)) &__Object::hashCode),
        getClass((Class (*)(B2)) &__Object::getClass),
        equals((bool (*)(B2, Object)) &__Object::equals) {}
    };

    struct __C;
    struct __C_VT;
    typedef __C* C;
    
    struct __C { 
      
      __C_VT* __vptr;
      
      __C();

      String c;

      static C __init();
      static Class __class();

      static __C_VT __vtable;
    };

    struct __C_VT { 
      Class __is_a;

      int32_t (*hashCode) (C);
      Class (*getClass) (C);
      bool (*equals) (C, Object);
      void (*setA) (C);
      void (*printOther) (C);
      String (*toString) (C);

      __C_VT()
      : __is_a(__C::__class()),
        setA((void (*)(C)) &__A::setA),
        printOther((void (*)(C)) &__A::printOther),
        toString((String (*)(C)) &__A::toString),
        hashCode((int32_t (*)(C)) &__Object::hashCode),
        getClass((Class (*)(C)) &__Object::getClass),
        equals((bool (*)(C, Object)) &__Object::equals) {}
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

    struct __Test010_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test010);
      Class (*getClass) (Test010);
      String (*toString) (Test010);
      bool (*equals) (Test010, Object);
      void (*main) (Test010);

      __Test010_VT()
      : __is_a(__Test010::__class()),
        hashCode((int32_t (*)(Test010)) &__Object::hashCode),
        getClass((Class (*)(Test010)) &__Object::getClass),
        toString((String (*)(Test010)) &__Object::toString),
        equals((bool (*)(Test010, Object)) &__Object::equals),
        main(&__Test010::main) {}
    };

  }
}
