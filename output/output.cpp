#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test027 {

    __A::__A() : __vptr(&__vtable), i(0)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable

    A __A:: __init(A__this) {

    }

<<<<<<< HEAD
    A __A::__init(A __this, int i) {

    }

    int32_t __A::get(A __this) {

    }

=======
    }
>>>>>>> 0e90a6e3ff13be10aa539fc0542e69d857cbbef4
  }
}
