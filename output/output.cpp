#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test008 {

    __A::__A() : __vptr(&__vtable), a(null)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable

    A __A::__init(A __this) {

    }

      __B::__B() : __vptr(&__vtable), b(null)
    {}

      Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

      __B_VT __B::__vtable

      B __B::__init(B __this) {

      }

    }
  }
