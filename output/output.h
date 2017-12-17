#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test014 {
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      A some;

      static void printOther_A(A, A);
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
      void (*printOther_A) (A, A);

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
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
    };

  }
}
