#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
  namespace test007 {

    __A::__A() : __vptr(&__vtable), a(__rt::null())
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A::__init(A __this) {
      __Object::__init((Object) __this);
      __this->a = __rt::literal("A");
      return __this;
    }
    
    __B::__B() : __vptr(&__vtable), b(__rt::null())
    {}

    Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

    __B_VT __B::__vtable;

    B __B::__init(B __this) {
      __A::__init((A) __this);
      __this->b = __rt::literal("B");
      return __this;
    }
    
  }
}
