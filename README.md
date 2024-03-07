# RPN-Calculator

# Overview

A simple RPN calculator written in Java. Input the string of operations and get a result.

[Software Demo Video](https://youtu.be/JF2usgNxJuE)

## Description

An RPN calculator (Reverse-Polish-Notation) is a tool used to evaluate math expressions written in Reverse Polish Notation (Sometiems called postfix notation). This notation is used to separate orders of operations without the need for parentheses, unlike the conventional notation used in schools (which is called infix notation). To perform an operation, enter two numbers (or expressions) followed by the operator.

1 1 +, for example, is equivalent to 1 + 1 in infix notation.

If I wanted to multiply this expression by 5, I would write the expression, then 5, then \*

1 1 + 5 \*

The program would solve this by first doing the 1 1 +, which after evaluation leaves us with 2 5 \*. The program then solves this expression leaving us with 10.

## Usage

The program will prompt you for an expression (all characters must be separated with a space)

Example:
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

Written in Visual Studio Code

# Future Work

- Expression converter -- infix: Infix notation expression converter that takes an equation like ((5 + 2) _ 5)^3 and rewrites it in RPN (Postfix) notation: 5 2 + 5 _ 3 ^
- Expression converter -- Postfix: Postfix notation converter that takes a postfix equation like 5 2 + 5 _ 3 ^ and returns it in infix format ((5 + 2) _ 5) ^ 3
- Continuous input: Right now, we ask the user to input an entire expression. We can actually solve the equations while the user inputs an equation and bind this to a GUI. Most users would be more used to using a calculator when presented in this format.
