import { cn } from '@/lib/utils';
import { Button } from '@/components/ui/button';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Link } from 'react-router';

export function RegisterForm({
	className,
	loginUrl,
	...props
}: {
	loginUrl: string;
} & React.ComponentPropsWithoutRef<'div'>) {
	return (
		<div className={cn('flex flex-col gap-6', className)} {...props}>
			<Card>
				<CardHeader>
					<CardTitle className="text-2xl">Register</CardTitle>
				</CardHeader>
				<CardContent>
					<form>
						<div className="flex flex-col gap-6">
							<div className="grid gap-2">
								<Label htmlFor="email">Email</Label>
								<Input id="email" type="email" placeholder="m@example.com" required />
							</div>
							<div className="grid gap-2">
								<Label htmlFor="password">Password</Label>
								<Input id="password" type="password" required />
							</div>
							<div className="grid gap-2">
								<Label htmlFor="password2">Confirm Password</Label>
								<Input id="password2" type="password" required />
							</div>
							<Button type="submit" className="w-full">
								Register
							</Button>
						</div>
						<div className="mt-4 text-center text-sm">
							Already have an account?{' '}
							<Link to={loginUrl} className="underline underline-offset-4">
								Log in
							</Link>
						</div>
					</form>
				</CardContent>
			</Card>
		</div>
	);
}
