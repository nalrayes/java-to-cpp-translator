#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test030 {
  
    struct __A;
    struct __A_VT;
    typedef __A* A;
    
    struct __A { 
      
      __A_VT* __vptr;
      
      __A();

      int32_t i;

      static int32_t get(A);
      static A __init(int32_t);
      static Class __class();

      static __A_VT __vtable;
    };

    struct __A_VT { 
      Class __is_a;

      int32_t (*hashCode) (A);
      Class (*getClass) (A);
      String (*toString) (A);
      bool (*equals) (A, Object);
      int32_t (*get) (A);

      __A_VT()
      : __is_a(__A::__class()),
        hashCode((int32_t (*)(A)) &__Object::hashCode),
        getClass((Class (*)(A)) &__Object::getClass),
        toString((String (*)(A)) &__Object::toString),
        equals((bool (*)(A, Object)) &__Object::equals),
        get(&__A::get) {}
    };

    struct __Test030;
    struct __Test030_VT;
    typedef __Test030* Test030;
    
    struct __Test030 { 
      
      __Test030_VT* __vptr;
      
      __Test030();

      static void main_String(Test030,String);
      static Test030 __init();
      static Class __class();

      static __Test030_VT __vtable;
    };

    struct __Test030_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test030);
      Class (*getClass) (Test030);
      String (*toString) (Test030);
      bool (*equals) (Test030, Object);

      __Test030_VT()
      : __is_a(__Test030::__class()),
        hashCode((int32_t (*)(Test030)) &__Object::hashCode),
        getClass((Class (*)(Test030)) &__Object::getClass),
        toString((String (*)(Test030)) &__Object::toString),
        equals((bool (*)(Test030, Object)) &__Object::equals),
        main_String(&__Test030::main_String) {}
    };

  }
}
