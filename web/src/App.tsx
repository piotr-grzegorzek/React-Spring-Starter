import * as React from 'react';
import { Button } from '@/components/ui/button';
import { Calendar } from '@/components/ui/calendar';

export default function App() {
	const [date, setDate] = React.useState<Date | undefined>(new Date());
	return (
		<>
			<Button>Click me</Button>
			<Calendar mode="single" selected={date} onSelect={setDate} className="rounded-md border" />
		</>
	);
}
