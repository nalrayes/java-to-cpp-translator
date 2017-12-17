#include "output.h"
#include <iostream>

using namespace java::lang;
using namespace std;

using namespace inputs::test007;

int main(void) {
  B b =  __B::__init(new __B));
  std::cout << b->a << std::endl;
  std::cout << b->b << std::endl;
  return 0;
}
