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
  std::cout << a->self->__vptr->toString(a->self) << std::endl;
  return 0;
}
