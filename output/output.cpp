#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test003 {

    __A::__A() : __vptr(&__vtable), fld(null)
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
    
    A __A::__init(A __this, String f) {
      __Object::__init((Object) __this);
      __this->fld = f;
      return __this;
    }
    
    String __A::getFld(A __this) {
      return __this->fld;
    }
    
  }
}
