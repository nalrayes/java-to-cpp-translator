#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

namespace inputs {
  namespace test001 {

    __A::__A() : __vptr(&__vtable)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable;

    A __A::__init(A __this) {
      __Object::__init((Object) __this);
      return __this;
    }
    
    String __A::toString(A __this) {
      return __rt::literal("A");
    }
    
  }
}
