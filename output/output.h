#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test022 {
  
    struct __Test022;
    struct __Test022_VT;
    typedef __Test022* Test022;
    
    struct __Test022 { 
      
      __Test022_VT* __vptr;
      
      __Test022();

      static void main_String(Test022,String);
      static Test022 __init();
      static Class __class();

      static __Test022_VT __vtable;
    };

    struct __Test022_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test022);
      Class (*getClass) (Test022);
      String (*toString) (Test022);
      bool (*equals) (Test022, Object);

      __Test022_VT()
      : __is_a(__Test022::__class()),
        hashCode((int32_t (*)(Test022)) &__Object::hashCode),
        getClass((Class (*)(Test022)) &__Object::getClass),
        toString((String (*)(Test022)) &__Object::toString),
        equals((bool (*)(Test022, Object)) &__Object::equals),
        main_String(&__Test022::main_String) {}
    };

  }
}
