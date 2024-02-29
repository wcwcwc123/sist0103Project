function f5(x,y,z=30){
    return x+y+z;
}
console.log(f5(1,2,3));
console.log(f5(10,20));


let a= 6;
let b= 6;

console.log(`a=b? ${a=b}`);
console.log(`a==b? ${a==b}`);
console.log(`a===b? ${a===b}`);
console.log(`Object.is(a,b)? ${Object.is(a,b)}`);