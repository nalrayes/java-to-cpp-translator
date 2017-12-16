#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

int main(void) {
  A a =  __A::__init(new__A();
  ({__rt::checkNotNull(a); a->__vptr->setA(a, __rt::literal("A"))});
  B1 b1 =  __B1::__init(new__B1();
  ({__rt::checkNotNull(b1); b1->__vptr->setA(b1, __rt::literal("B1"))});
  B2 b2 =  __B2::__init(new__B2();
  ({__rt::checkNotNull(b2); b2->__vptr->setA(b2, __rt::literal("B2"))});
  C c =  __C::__init(new__C();
  ({__rt::checkNotNull(c); c->__vptr->setA(c, __rt::literal("C"))});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, a)});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, b1)});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, b2)});
  ({__rt::checkNotNull(a); a->__vptr->printOther(a, c)});
  return 0;
}
