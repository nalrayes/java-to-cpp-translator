#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
<<<<<<< HEAD
  namespace test003 {
=======
  namespace test024 {
>>>>>>> da8d60e15cca51444a6d1aa4c9112bd77185f960
  
    struct __A;
    struct __A_VT;
    typedef __rt::Ptr<__A> A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

<<<<<<< HEAD
      String fld;

      static String getFld(A);
      static A __init(A, String);
=======
      int32_t i;

      static int32_t get(A);
      static A __init(A, int32_t);
>>>>>>> da8d60e15cca51444a6d1aa4c9112bd77185f960
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
      String (*getFld) (A);
=======
      int32_t (*get) (A);
>>>>>>> da8d60e15cca51444a6d1aa4c9112bd77185f960

      __A_VT()
      : __is_a(__A::__class()),
        __delete(__rt::__delete<__A>),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        equals((bool (*)(A, Object)) &__Object::equals),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
<<<<<<< HEAD
        getFld(&__A::getFld) {}
    };

    struct __Test003;
    struct __Test003_VT;
    typedef __rt::Ptr<__Test003> Test003;
    
    struct __Test003 { 
      
      __Test003_VT* __vptr;
      
      __Test003();

      static void main_String(Test003, String);
      static Test003 __init(Test003 __this);
      static Class __class();

      static __Test003_VT __vtable;
    };

    struct __Test003_VT { 
      Class __is_a;

      void (*__delete) (__Test003*);
      int32_t (*hashCode) (Test003);
      bool (*equals) (Test003, Object);
      Class (*getClass) (Test003);
      String (*toString) (Test003);
      void (*main_String) (Test003, String);

      __Test003_VT()
      : __is_a(__Test003::__class()),
        __delete(__rt::__delete<__Test003>),
        hashCode((int32_t (*)(Test003)) &__Object::hashCode),
        equals((bool (*)(Test003, Object)) &__Object::equals),
        getClass((Class (*)(Test003)) &__Object::getClass),
        toString((String (*)(Test003)) &__Object::toString),
        main_String(&__Test003::main_String) {}
=======
        get(&__A::get) {}
    };

    struct __Test024;
    struct __Test024_VT;
    typedef __rt::Ptr<__Test024> Test024;
    
    struct __Test024 { 
      
      __Test024_VT* __vptr;
      
      __Test024();

      static void main_String(Test024, String);
      static Test024 __init(Test024 __this);
      static Class __class();

      static __Test024_VT __vtable;
    };

    struct __Test024_VT { 
      Class __is_a;

      void (*__delete) (__Test024*);
      int32_t (*hashCode) (Test024);
      bool (*equals) (Test024, Object);
      Class (*getClass) (Test024);
      String (*toString) (Test024);
      void (*main_String) (Test024, String);

      __Test024_VT()
      : __is_a(__Test024::__class()),
        __delete(__rt::__delete<__Test024>),
        hashCode((int32_t (*)(Test024)) &__Object::hashCode),
        equals((bool (*)(Test024, Object)) &__Object::equals),
        getClass((Class (*)(Test024)) &__Object::getClass),
        toString((String (*)(Test024)) &__Object::toString),
        main_String(&__Test024::main_String) {}
>>>>>>> da8d60e15cca51444a6d1aa4c9112bd77185f960
    };

  }
}
