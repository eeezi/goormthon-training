import React, { useState } from "react";

function ExpenseForm({ addExpense }) {
  const [name, setName] = useState("");
  const [amount, setAmount] = useState("");

  // 폼 제출 시 새로운 지출 항목 추가
  const handleSubmit = (e) => {
    e.preventDefault();
    if (name.trim() === "" || amount.trim() === "") return;

    const newExpense = {
      id: Date.now(),
      name: name,
      amount: parseFloat(amount),
    };

    addExpense(newExpense);
    setName("");
    setAmount("");
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="input">
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="지출항목"
        />
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          placeholder="0원"
        />
        <button type="submit">제출</button>
      </div>
    </form>
  );
}

export default ExpenseForm;
