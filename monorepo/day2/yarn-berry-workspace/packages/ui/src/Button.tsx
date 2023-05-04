import { ButtonHTMLAttributes, MouseEventHandler, ReactNode } from 'react';

export type ButtonProps = ButtonHTMLAttributes<HTMLButtonElement> & {
  children: ReactNode;
  variant: 'contained' | 'outlined';
  onClick?: MouseEventHandler<HTMLButtonElement>;
};

const Button = (props: ButtonProps) => {
  const { children, onClick, ...other } = props;

  return (
    <button type="button" onClick={onClick} {...other}>
      {children}
    </button>
  );
};

export default Button;
