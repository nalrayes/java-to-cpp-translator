#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

int main(void) {
  __rt::Ptr<A, __rt::object_policy> a = new A();
  Object o = a;
  std::cout << o->__vptr->toString(o) << std::endl;
  return 0;
}
