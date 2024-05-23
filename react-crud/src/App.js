import React, { useState, useEffect } from "react";
import ExpenseForm from "./ExpenseForm";
import ExpenseList from "./ExpenseList";
import "./App.css";

function App() {
  const [expenses, setExpenses] = useState(() => {
    // 초기 상태를 로컬스토리지에서 불러오기
    const storedExpenses = localStorage.getItem("expenses");
    return storedExpenses ? JSON.parse(storedExpenses) : [];
  });

  // expenses가 변경될 때마다 로컬스토리지에 저장
  useEffect(() => {
    localStorage.setItem("expenses", JSON.stringify(expenses));
  }, [expenses]);

  // 새로운 지출 항목 추가
  const addExpense = (expense) => {
    setExpenses([...expenses, expense]);
  };

  // 지출 항목 삭제
  const removeExpense = (id) => {
    setExpenses(expenses.filter((expense) => expense.id !== id));
  };

  // 모든 지출 항목 삭제
  const removeAllExpenses = () => {
    setExpenses([]);
  };

  // 지출 항목 수정
  const updateExpense = (id, updatedExpense) => {
    setExpenses(
      expenses.map((expense) => (expense.id === id ? updatedExpense : expense))
    );
  };

  // 총 지출액 계산
  const totalExpense = expenses.reduce(
    (total, expense) => total + expense.amount,
    0
  );

  return (
    <div className="App">
      <h1>예산 계산기</h1>
      <ExpenseForm addExpense={addExpense} />
      <ExpenseList
        expenses={expenses}
        removeExpense={removeExpense}
        updateExpense={updateExpense}
      />
      <button onClick={removeAllExpenses}>목록 지우기</button>
      <h2>총 지출: {totalExpense}원</h2>
    </div>
  );
}

export default App;
