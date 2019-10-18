export interface Product {
  id: number;
  name: string;
  image: string;
  type: ProductType;
  status: ProductStatus;
  weight: number;
  amount: number;
  inDate: Date;
  outDate: Date;
  expiryDate: Date;
}

export interface ProductType {
  id: number;
  name: string;
  unit: string;
}

export enum ProductStatus {
  OUT_DATE = 'OUT_DATE',
  INITIAL = 'INITIAL',
  AVAILABLE = 'AVAILABLE',
  PROCESS = 'PROCESS',
}
