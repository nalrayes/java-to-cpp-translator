#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test012 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      static void setA(A,String);
      static void printOther(A,A);
      static String myToString(A);
      static A __init();
      String a;

      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);
      void (*setA) (A);
      void (*printOther) (A);
      String (*myToString) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        setA(&__A::setA),
        printOther(&__A::printOther),
        myToString(&__A::myToString) {}
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

    struct __B1_VT { 
      Class __is_a;

      void (*setA) (B1);
      void (*printOther) (B1);
      String (*myToString) (B1);
      int32_t (*hashCode) (B1);
      Class (*getClass) (B1);
      String (*toString) (B1);
      bool (*equals) (B1, Object);

      __B1_VT()
      : __is_a(__B1::__class()),
        setA((void (*)(B1)) &__A::setA),
        printOther((void (*)(B1)) &__A::printOther),
        myToString((String (*)(B1)) &__A::myToString),
        hashCode((int32_t (*)(B1)) &__Object::hashCode),
        getClass((Class (*)(B1)) &__Object::getClass),
        toString((String (*)(B1)) &__Object::toString),
        equals((bool (*)(B1, Object)) &__Object::equals) {}
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

    struct __B2_VT { 
      Class __is_a;

      void (*setA) (B2);
      void (*printOther) (B2);
      String (*myToString) (B2);
      int32_t (*hashCode) (B2);
      Class (*getClass) (B2);
      String (*toString) (B2);
      bool (*equals) (B2, Object);

      __B2_VT()
      : __is_a(__B2::__class()),
        setA((void (*)(B2)) &__A::setA),
        printOther((void (*)(B2)) &__A::printOther),
        myToString((String (*)(B2)) &__A::myToString),
        hashCode((int32_t (*)(B2)) &__Object::hashCode),
        getClass((Class (*)(B2)) &__Object::getClass),
        toString((String (*)(B2)) &__Object::toString),
        equals((bool (*)(B2, Object)) &__Object::equals) {}
    };

    struct __C;
    struct __C_VT;
    typedef __C* C;
    
    struct __C { 
      
      __C_VT* __vptr;
      
      __C();

      static String myToString(C);
      static C __init();
      String c;

      static Class __class();

      static __C_VT __vtable;
    };

    struct __C_VT { 
      Class __is_a;

      void (*setA) (C);
      void (*printOther) (C);
      int32_t (*hashCode) (C);
      Class (*getClass) (C);
      String (*toString) (C);
      bool (*equals) (C, Object);
      String (*myToString) (C);

      __C_VT()
      : __is_a(__C::__class()),
        setA((void (*)(C)) &__A::setA),
        printOther((void (*)(C)) &__A::printOther),
        hashCode((int32_t (*)(C)) &__Object::hashCode),
        getClass((Class (*)(C)) &__Object::getClass),
        toString((String (*)(C)) &__Object::toString),
        equals((bool (*)(C, Object)) &__Object::equals),
        myToString(&__C::myToString) {}
    };

    struct __Test012;
    struct __Test012_VT;
    typedef __Test012* Test012;
    
    struct __Test012 { 
      
      __Test012_VT* __vptr;
      
      __Test012();

      static void main(Test012,String);
      static Test012 __init();
      static Class __class();

      static __Test012_VT __vtable;
    };

    struct __Test012_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test012);
      Class (*getClass) (Test012);
      String (*toString) (Test012);
      bool (*equals) (Test012, Object);
      void (*main) (Test012);

      __Test012_VT()
      : __is_a(__Test012::__class()),
        hashCode((int32_t (*)(Test012)) &__Object::hashCode),
        getClass((Class (*)(Test012)) &__Object::getClass),
        toString((String (*)(Test012)) &__Object::toString),
        equals((bool (*)(Test012, Object)) &__Object::equals),
        main(&__Test012::main) {}
    };

  }
}
