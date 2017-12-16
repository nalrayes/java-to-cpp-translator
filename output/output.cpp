#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test038 {

    __A::__A() : __vptr(&__vtable)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A:: __init(A__this) {
      return __this;
    }
    
    void __A::m_Object_Object(A __this, Object o1, Object o2) {
      std::cout << __rt::literal("A.m(Object, Object)") << std::endl;
    }
    
    void __A::m_A_Object(A __this, A a1, Object o2) {
      std::cout << __rt::literal("A.m(A, Object)") << std::endl;
    }
    
    void __A::m_Object_A(A __this, Object o1, A a2) {
      std::cout << __rt::literal("A.m(Object, A)") << std::endl;
    }
    
    __B::__B() : __vptr(&__vtable)
    {}

    Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

    __B_VT __B::__vtable;

    B __B:: __init(B__this) {
      return __this;
    }
    
    void __B::m_Object_Object(B __this, Object o1, Object o2) {
      std::cout << __rt::literal("B.m(Object, Object)") << std::endl;
    }
    
    void __B::m_B_Object(B __this, B a1, Object o2) {
      std::cout << __rt::literal("B.m(B, Object)") << std::endl;
    }
    
    void __B::m_Object_B(B __this, Object o1, B a2) {
      std::cout << __rt::literal("B.m(Object, B)") << std::endl;
    }
    
  }
}
