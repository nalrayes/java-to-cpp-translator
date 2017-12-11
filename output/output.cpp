#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test017 {

    __A::__A() : __vptr(&__vtable), self(null)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable

    A __A:: __init(A__this) {

 }

  A __A::__init(A __this, int x) {

 }

A __A::self(A __this) {

 }

}
}
