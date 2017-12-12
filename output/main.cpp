#pragma once
#include "java_lang.h"
#include <string>
#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace inputs::constructors;
using namespace namespace std;

int main(void) {
  __rt::Ptr<A, __rt::array_policy> as =  new B[10];
  for (int i = 0; i < as.length; i++) {
    (*as)[i] = __A::__init(new __A(), , i);
  }
  int k = 0;
  while (k < 10) {
    std::cout << (A) (*as)[k]->__vptr->get((A) (*as)[k]) << std::endl;
    k = k + 1;
  }
  return 0;
}
