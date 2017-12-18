#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
<<<<<<< HEAD
  namespace test010 {
=======
  namespace test014 {
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

<<<<<<< HEAD
      String a;

      static void setA_String(A, String);
      static void printOther_A(A, A);
      static String toString(A);
=======
      A some;

      static void printOther_A(A, A);
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
      static A __init(A __this);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      void (*__delete) (__A*);
      int32_t (*hashCode) (A);
      bool (*equals) (A, Object);
      Class (*getClass) (A);
      String (*toString) (A);
<<<<<<< HEAD
      void (*setA_String) (A, String);
=======
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
      void (*printOther_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
<<<<<<< HEAD
        toString(&__A::toString),
        setA_String(&__A::setA_String),
        printOther_A(&__A::printOther_A) {}
    };

    struct __B1;
    struct __B1_VT;
    typedef __rt::Ptr<__B1> B1;
    
    struct __B1 { 
      
      __B1_VT* __vptr;
      
      __B1();

      String b;

      static B1 __init(B1 __this);
      static Class __class();

      static __B1_VT __vtable;
    };

    struct __B1_VT { 
      Class __is_a;

      void (*__delete) (__B1*);
      int32_t (*hashCode) (B1);
      bool (*equals) (B1, Object);
      Class (*getClass) (B1);
      String (*toString) (B1);
      void (*setA_String) (B1, String);
      void (*printOther_A) (B1, A);

      __B1_VT()
      : __is_a(__B1::__class()),
        __delete(__rt::__delete<__B1>),
        hashCode((int32_t (*)(B1)) &__Object::hashCode),
        equals((bool (*)(B1, Object)) &__Object::equals),
        getClass((Class (*)(B1)) &__Object::getClass),
        toString((String (*)(B1)) &__A::toString),
        setA_String((void (*)(B1)) &__A::setA_String),
        printOther_A((void (*)(B1)) &__A::printOther_A) {}
    };

    struct __B2;
    struct __B2_VT;
    typedef __rt::Ptr<__B2> B2;
    
    struct __B2 { 
      
      __B2_VT* __vptr;
      
      __B2();

      String b;

      static B2 __init(B2 __this);
      static Class __class();

      static __B2_VT __vtable;
    };

    struct __B2_VT { 
      Class __is_a;

      void (*__delete) (__B2*);
      int32_t (*hashCode) (B2);
      bool (*equals) (B2, Object);
      Class (*getClass) (B2);
      String (*toString) (B2);
      void (*setA_String) (B2, String);
      void (*printOther_A) (B2, A);

      __B2_VT()
      : __is_a(__B2::__class()),
        __delete(__rt::__delete<__B2>),
        hashCode((int32_t (*)(B2)) &__Object::hashCode),
        equals((bool (*)(B2, Object)) &__Object::equals),
        getClass((Class (*)(B2)) &__Object::getClass),
        toString((String (*)(B2)) &__A::toString),
        setA_String((void (*)(B2)) &__A::setA_String),
        printOther_A((void (*)(B2)) &__A::printOther_A) {}
    };

    struct __C;
    struct __C_VT;
    typedef __rt::Ptr<__C> C;
    
    struct __C { 
      
      __C_VT* __vptr;
      
      __C();

      String c;

      static C __init(C __this);
      static Class __class();

      static __C_VT __vtable;
    };

    struct __C_VT { 
      Class __is_a;

      void (*__delete) (__C*);
      int32_t (*hashCode) (C);
      bool (*equals) (C, Object);
      Class (*getClass) (C);
      String (*toString) (C);
      void (*setA_String) (C, String);
      void (*printOther_A) (C, A);

      __C_VT()
      : __is_a(__C::__class()),
        __delete(__rt::__delete<__C>),
        hashCode((int32_t (*)(C)) &__Object::hashCode),
        equals((bool (*)(C, Object)) &__Object::equals),
        getClass((Class (*)(C)) &__Object::getClass),
        toString((String (*)(C)) &__A::toString),
        setA_String((void (*)(C)) &__A::setA_String),
        printOther_A((void (*)(C)) &__A::printOther_A) {}
    };

    struct __Test010;
    struct __Test010_VT;
    typedef __rt::Ptr<__Test010> Test010;
    
    struct __Test010 { 
      
      __Test010_VT* __vptr;
      
      __Test010();

      static void main_String(Test010, String);
      static Test010 __init(Test010 __this);
      static Class __class();

      static __Test010_VT __vtable;
    };

    struct __Test010_VT { 
      Class __is_a;

      void (*__delete) (__Test010*);
      int32_t (*hashCode) (Test010);
      bool (*equals) (Test010, Object);
      Class (*getClass) (Test010);
      String (*toString) (Test010);
      void (*main_String) (Test010, String);

      __Test010_VT()
      : __is_a(__Test010::__class()),
        __delete(__rt::__delete<__Test010>),
        hashCode((int32_t (*)(Test010)) &__Object::hashCode),
        equals((bool (*)(Test010, Object)) &__Object::equals),
        getClass((Class (*)(Test010)) &__Object::getClass),
        toString((String (*)(Test010)) &__Object::toString),
        main_String(&__Test010::main_String) {}
=======
        toString((String (*)(A)) &__Object::toString),
        printOther_A(&__A::printOther_A) {}
    };

    struct __Test014;
    struct __Test014_VT;
    typedef __rt::Ptr<__Test014> Test014;
    
    struct __Test014 { 
      
      __Test014_VT* __vptr;
      
      __Test014();

      static void main_String(Test014, String);
      static Test014 __init(Test014 __this);
      static Class __class();

      static __Test014_VT __vtable;
    };

    struct __Test014_VT { 
      Class __is_a;

      void (*__delete) (__Test014*);
      int32_t (*hashCode) (Test014);
      bool (*equals) (Test014, Object);
      Class (*getClass) (Test014);
      String (*toString) (Test014);
      void (*main_String) (Test014, String);

      __Test014_VT()
      : __is_a(__Test014::__class()),
        __delete(__rt::__delete<__Test014>),
        hashCode((int32_t (*)(Test014)) &__Object::hashCode),
        equals((bool (*)(Test014, Object)) &__Object::equals),
        getClass((Class (*)(Test014)) &__Object::getClass),
        toString((String (*)(Test014)) &__Object::toString),
        main_String(&__Test014::main_String) {}
>>>>>>> 36ee1741fe9486eddbb8956b4a692daff79ee824
    };

  }
}
