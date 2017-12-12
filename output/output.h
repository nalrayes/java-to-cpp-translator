#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
  namespace test029 {
  
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

    struct __Test029;
    struct __Test029_VT;
    typedef __Test029* Test029;
    
    struct __Test029 { 
      
      __Test029_VT* __vptr;
      
      __Test029();

      static void main_String(Test029,String);
      static Test029 __init();
      static Class __class();

      static __Test029_VT __vtable;
    };

    struct __Test029_VT { 
      Class __is_a;

      int32_t (*hashCode) (Test029);
      Class (*getClass) (Test029);
      String (*toString) (Test029);
      bool (*equals) (Test029, Object);

      __Test029_VT()
      : __is_a(__Test029::__class()),
        hashCode((int32_t (*)(Test029)) &__Object::hashCode),
        getClass((Class (*)(Test029)) &__Object::getClass),
        toString((String (*)(Test029)) &__Object::toString),
        equals((bool (*)(Test029, Object)) &__Object::equals),
        main_String(&__Test029::main_String) {}
    };

  }
}
