//CommonJs写法
const {add,mul} = require('./mathUtil.js')

//ES6写法
import{age,name} from './info.js'

console.log(add(20,30));
console.log(mul(20,30));

console.log(name);
console.log(age);
