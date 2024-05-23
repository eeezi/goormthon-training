import React, { useState } from 'react';

function ExpenseItem({ expense, removeExpense, updateExpense }) {
  const [isEditing, setIsEditing] = useState(false);
  const [newName, setNewName] = useState(expense.name);
  const [newAmount, setNewAmount] = useState(expense.amount);

  // 수정 모드로 전환
  const handleEdit = () => {
    setIsEditing(true);
  };

  // 수정 내용 저장
  const handleSave = () => {
    updateExpense(expense.id, { ...expense, name: newName, amount: parseFloat(newAmount) });
    setIsEditing(false);
  };

  // 입력 필드 변경
  const handleChangeName = (e) => {
    setNewName(e.target.value);
  };

  const handleChangeAmount = (e) => {
    setNewAmount(e.target.value);
  };

  return (
    <li>
      {isEditing ? (
        <>
          <input type="text" value={newName} onChange={handleChangeName} />
          <input type="number" value={newAmount} onChange={handleChangeAmount} />
          <button onClick={handleSave}>저장</button>
        </>
      ) : (
        <>
          <span>{expense.name}</span>
          <span>{expense.amount}원</span>
          <button onClick={handleEdit}>수정</button>
          <button onClick={() => removeExpense(expense.id)}>삭제</button>
        </>
      )}
    </li>
  );
}

export default ExpenseItem;
