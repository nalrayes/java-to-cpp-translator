#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

int main(void) {
  A a =  __A::__init(new__A());
  ({Object tmp0 = ({__rt::checkNotNull(a); a->__vptr->m(a, a)}); __rt::checkNotNull(tmp0); tmp0->__vptr->m(tmp0)});
  B b =  __B::__init(new__B());
  ({Object tmp0 = ({__rt::checkNotNull(b); b->__vptr->m(b, b)}); __rt::checkNotNull(tmp0); tmp0->__vptr->m(tmp0)});
  ({Object tmp0 = ({__rt::checkNotNull(b); b->__vptr->m(b, __rt::java_cast<A>(b))}); __rt::checkNotNull(tmp0); tmp0->__vptr->m(tmp0)});
  return 0;
}
