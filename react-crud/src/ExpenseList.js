import React from 'react';
import ExpenseItem from './ExpenseItem';

function ExpenseList({ expenses, removeExpense, updateExpense }) {
  return (
    <ul>
      {expenses.map((expense) => (
        <ExpenseItem key={expense.id} expense={expense} removeExpense={removeExpense} updateExpense={updateExpense} />
      ))}
    </ul>
  );
}

export default ExpenseList;