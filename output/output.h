#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test023 {
  
    struct __Test023;
    struct __Test023_VT;
    typedef __rt::Ptr<__Test023> Test023;
    
    struct __Test023 { 
      
      __Test023_VT* __vptr;
      
      __Test023();

      static void main_String(Test023, String);
      static Test023 __init(Test023 __this);
      static Class __class();

      static __Test023_VT __vtable;
    };

    struct __Test023_VT { 
      Class __is_a;

      void (*__delete) (__Test023*);
      int32_t (*hashCode) (Test023);
      bool (*equals) (Test023, Object);
      Class (*getClass) (Test023);
      String (*toString) (Test023);
      void (*main_String) (Test023, String);

      __Test023_VT()
      : __is_a(__Test023::__class()),
        __delete(__rt::__delete<__Test023>),
        hashCode((int32_t (*)(Test023)) &__Object::hashCode),
        equals((bool (*)(Test023, Object)) &__Object::equals),
        getClass((Class (*)(Test023)) &__Object::getClass),
        toString((String (*)(Test023)) &__Object::toString),
        main_String(&__Test023::main_String) {}
    };

  }
}
