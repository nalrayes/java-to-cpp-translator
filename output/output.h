#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace test000 {

struct __Test000;

struct __Test000 { 
__Test000();

void __main(String);
Test000 __init();

};



struct __Test000_VT;

struct __Test000_VT {

int32_t *(hashCode) (Test000);
Class *(getClass) (Test000);
String *(toString) (Test000);
boolean *(equals) (Test000);
void *(main) (Test000);

__Test000_VT()
 : __is_a(__Test000::__class()),
hashCode((int32_t (*)(Test000))_Test000 &_Object::hashCode),
getClass((Class (*)(Test000))_Test000 &_Object::getClass),
toString((String (*)(Test000))_Test000 &_Object::toString),
equals((boolean (*)(Test000))_Test000 &_Object::equals),
main((void (*)(Test000))_Test000 &_Test000::main)
{
}
};


}
}
