#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

namespace inputs {
  namespace test025 {

    __A::__A() : __vptr(&__vtable), i(0)
    {}

    Class __A::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.A"), __Object::__class());
      return k;
    }

    __A_VT __A::__vtable

    A __A:: __init(A__this) {

      return __this;

      A __A::__init(A __this, int i) {

        __Object::__init((Object) __this)
        __this->i = i;
        return __this;

        int32_t __A::get(A __this) {

          return __this->i;

            __B::__B() : __vptr(&__vtable)
    {}

            Class __B::__class() {
      static Class k =
        new __Class(__rt::literal("inputs.javalang.B"), __A::__class());
      return k;
    }

            __B_VT __B::__vtable

            B __B:: __init(B__this) {

              return __this;

              B __B::__init(B __this, int i) {

                __A::__init((A) __this, i)
                return __this;

                int32_t __B::get(B __this) {

                  return 10 + __this->i;

                  for (int i = 0; i < as.length; i++)
                  (*as)[i] = __B::__init(new __B(), , i);
                  while (k < 10)
                  std::cout << (A) (*as)[k]->__vptr->get((A) (*as)[k]) << std::endl;
                  k = k + 1;
                }
              }
