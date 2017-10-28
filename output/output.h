#pragma once
#include "java_lang.h"
#include <string>

using namespace java::lang;

namespace inputs {
namespace test017 {

struct __A;

struct __A { 
__A();

A __self();
A __init(int32_t);

A self;

};


struct __Test017;

struct __Test017 { 
__Test017();

void __main(String);
Test017 __init();

};



struct A;

struct A { 
int32_t (*hashCode)((A));
bool (*equals)((A));
Class (*getClass)((A));
String (*toString)((A));
A (*self)(A);

};


struct Test017;

struct Test017 { 
int32_t (*hashCode)((Test017));
bool (*equals)((Test017));
Class (*getClass)((Test017));
String (*toString)((Test017));
void (*main)(Test017);

};


}
}
