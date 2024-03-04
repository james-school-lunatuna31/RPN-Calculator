# RPN-Calculator

# Overview

A simple RPN calculator written in Java. Input the string of operations and get a result.

[Software Demo Video](http://youtube.link.goes.here)

## Description

An RPN calculator (Reverse-Polish-Notation) is a tool used to evaluate math expressions written in Reverse Polish Notation (sometimes called prefix or infix). This notation is used to seperate orders of operations without the need for parenthesis (which is how you see equations in school. This is called postfix). To perform an operation, enter two numbers (or expressions) followed by the oeprator. 

1 1 + for example, is equivilant to 1 + 1.

If I wanted to multiply this expression by 5, I would write the expression, then 5, then *

1 1 + 5 *

The program would solve this be first doing the 1 1 + which after evaluation leaves us wit 2 5 *. The program then solves this expression leaving us with 10.

## Usage

The program will prompt you for an expression (all characters must be seperated with a space)

Emaple:
`Please enter an expression: 5 5 +
Output: 10
`

`Please enter an expression: 5 5 1 + *
Output: 30
`

`Please enter an expression: 1 1 + 5 *
Output: 10
`
# Useful websites.

RPN: https://en.wikipedia.org/wiki/Reverse_Polish_notation
Stacks: https://www.geeksforgeeks.org/stack-class-in-java/ 

# Development Environment

Written in Visual Stuio Code


# Future Work

- Expression converter -- postfix: Postfix notation expression converter that takes an equation like ((5 + 2) * 5)^3 and rewrites it in prefix equation: 5 2 + 5 * 3 ^
- Expression converter -- prefix: Prefix notation expression converter that takes a prefix equation like 5 2 + 5 * 3 ^ and returns a postfix equation: ((5 + 2) * 5) ^3
- Continous input: Right now, we ask the user to input an entire expression. We can actually solve the equations while the user inputs an equation and bind this to a gui. Most users would be more used to using a calculator when presented in this format.
