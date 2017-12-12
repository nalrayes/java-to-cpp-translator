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
  std::cout << a->__vptr->toString(a) << std::endl;
  return 0;
}
