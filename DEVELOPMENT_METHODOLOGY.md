# Quantity Measurement App Development Methodology

## Purpose

This project uses a hybrid approach that combines:

- Design-Develop-Test (DDT) for macro-level planning and system validation
- Test-Driven Development (TDD) for micro-level implementation inside each use case

The objective is to produce correct, maintainable code with strong test coverage and predictable delivery.

## Why TDD Is Included

TDD improves implementation quality by requiring behavior to be defined first.

- Cleaner design: interfaces and behavior are clarified before implementation details
- High test coverage: code is written in response to failing tests
- Confidence to change: fast regression checks support safe refactoring
- Living documentation: tests show intended behavior and usage

## DDT vs TDD

| Feature | Traditional DDT | TDD |
| --- | --- | --- |
| When to test | After code is written | Before code is written |
| Primary goal | Find defects | Drive design and logic |
| Focus | Validation of built code | Requirement fulfillment from tests |
| Refactoring risk | Higher, due to possible test gaps | Lower, protected by passing test suite |
| Feedback loop | Longer | Short and immediate |

## How DDT and TDD Coexist in This Project

TDD does not replace high-level design. It replaces the implementation habit.

1. System Design (DDT layer)
   - Define architecture, object model, module boundaries, conversion rules, and API/UI contracts.
2. Component Implementation (TDD layer)
   - Build each use case using Red-Green-Refactor cycles.
3. System Validation (DDT layer)
   - Run integration tests and UAT to verify real-world behavior across components.

## Execution Model per Use Case

For every use case (for example: UC1 Feet Equality), follow this sequence:

1. Design
   - Clarify scope boundaries, inputs, outputs, constraints, and acceptance criteria.
2. Test First (Red)
   - Write failing unit tests for expected behavior and edge cases.
3. Minimal Code (Green)
   - Implement only enough production code to pass tests.
4. Refactor
   - Improve readability/design while keeping tests green.
5. Integrate
   - Merge use case changes into dev after review and successful CI/local test run.

## Development Principles

- Start simple: begin with equality checks for a single quantity type
- Grow incrementally: add quantity types and conversions use-case by use-case
- Keep strict scope: do not implement beyond current use-case acceptance criteria
- Build full stack as needed: backend domain logic plus frontend behavior required by each use case

## Minimum Test Strategy

At project level, tests must verify:

- Unit conversions are mathematically correct
- Edge and boundary conditions are handled
- Invalid inputs are rejected with clear failures
- All meaningful code paths are exercised

Recommended test categories:

- Unit tests: domain classes, conversion logic, equality/comparison behavior
- Integration tests: interactions between domain logic, APIs, and persistence (if applicable)
- End-to-end/UAT tests: user-facing scenarios across frontend and backend

## Quality Gates

Before merging a feature branch into dev:

- All unit tests pass
- No failing integration checks
- Scope of the use case is complete
- Code review comments are addressed

Before merging dev into main:

- Project compiles/builds successfully
- Regression suite passes
- Integration/UAT checks pass for release scope

## TDD Red-Green-Refactor Quick Reference

- Red: write a failing test that defines one behavior
- Green: write the simplest code to pass that test
- Refactor: improve code structure without changing behavior

Repeat in small cycles for each behavior.
